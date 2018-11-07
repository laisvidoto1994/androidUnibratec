package com.example.diego.desafioandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout appContainer;
    private CustomScrollView scrollView;
    private LinearLayout mainLayout;
    private RequestQueue queue;

    private List<ImageBox> images = new ArrayList<>();
    private int currentPage;
    private TextView pageText;

    private String token = "&access_token=23d8c132e9e9b7fc887ec535b694c4324f0fa6ebbd3e5c8983aad18609d8fd1d";

    private Gson gson;
    private GetJSON json;

    private String jsonData;

    private GestureDetector swipeDetector;

    private Runnable animationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "Swipe horizontal para troca de tela. \n Clique nas imagens para ver seu conteúdo.", Toast.LENGTH_LONG).show();

        Utility.Init(this);
        setContentView(R.layout.activity_main);

        ShotDetails.Init(this);

        gson = new Gson();
        json = new GetJSON(this);

        appContainer = (LinearLayout)findViewById(R.id.appContainer);
        scrollView = (CustomScrollView)findViewById(R.id.scrollView);
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        pageText = (TextView)findViewById(R.id.pageText);

        currentPage = 1;

        swipeDetector = new GestureDetector(this, new SwipeDetector());

        loadData(LoadType.START);
    }

    private void loadData(LoadType _type){
        final LoadType type = _type;
        String url = "https://api.dribbble.com/v1/shots?page=" + currentPage + token;

        queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        jsonData = response;

                        switch(type){
                            case START:
                                continueCreateProcess();
                                break;
                            default:
                                updatePage();
                                break;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {}
        });
        queue.add(stringRequest);
    }

    public void continueCreateProcess(){
        Shot[] shots;
        shots = gson.fromJson(jsonData, Shot[].class);

        for(int i = 0; i <= shots.length - 1; i++){
            ImageBox imageBox = new ImageBox(this, scrollView, shots[i]);

            images.add(imageBox);

            imageBox.insertContainerInto(mainLayout);
        }

        ImageBox fakeBox = new ImageBox(this);
        fakeBox.getContainer().setAlpha(0);
        fakeBox.insertContainerInto(mainLayout);
    }

    private void updatePage(){

        Shot[] shots;
        shots = gson.fromJson(jsonData, Shot[].class);

        ImageBox imgBox;

        for(int i = 0; i <= images.size() - 1; i++){
            imgBox = images.get(i);
            imgBox.getImageLoader().task.cancel(true);
            imgBox.clearImage();
            imgBox.loadInfo(shots[i]);
        }

        scrollView.animate()
                .alpha(1f)
                .setListener(null)
                .setDuration(500)
                .start();
    }

    private void goToNextPage(){
        if(ImageBox.instance != null) return;

        scrollView.animate()
                .translationX(scrollView.getX() - scrollView.getWidth())
                .alpha(0f)
                .setDuration(500)
                .setListener(null)
                .withEndAction(animationCallback = new Runnable() {
                    @Override
                    public void run() {
                        scrollView.setX(0f);
                        scrollView.scrollTo(0, 0);

                        currentPage++;
                        pageText.setText("Página: " + currentPage);
                        loadData(LoadType.UPDATE);
                    }
                })
                .start();
    }

    private void goToPrevPage(){
        if(currentPage == 1 || ImageBox.instance != null) return;

        scrollView.animate()
                .translationX(scrollView.getX() + scrollView.getWidth())
                .alpha(0f)
                .setDuration(500)
                .setListener(null)
                .withEndAction(animationCallback = new Runnable() {
                    @Override
                    public void run() {
                        scrollView.setX(0f);
                        scrollView.scrollTo(0, 0);

                        currentPage--;
                        pageText.setText("Página: " + currentPage);
                        loadData(LoadType.UPDATE);
                    }
                })
                .start();
    }

    @Override
    public boolean dispatchTouchEvent( MotionEvent ev ) {
        // TouchEvent dispatcher.
        if( swipeDetector != null ) {
            if( swipeDetector.onTouchEvent( ev ) )
                // If the gestureDetector handles the event, a swipe has been
                // executed and no more needs to be done.
                return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent( MotionEvent event ) {
        return swipeDetector.onTouchEvent(event);
    }

    private class SwipeDetector extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_MAX_OFF_PATH = 250;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling( MotionEvent e1, MotionEvent e2, float velocityX, float velocityY ) {

            // Check movement along the Y-axis. If it exceeds SWIPE_MAX_OFF_PATH,
            // then dismiss the swipe.
            if( Math.abs( e1.getY() - e2.getY() ) > SWIPE_MAX_OFF_PATH )
                return false;

            // Swipe from right to left.
            // The swipe needs to exceed a certain distance (SWIPE_MIN_DISTANCE)
            // and a certain velocity (SWIPE_THRESHOLD_VELOCITY).
            if( e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs( velocityX ) > SWIPE_THRESHOLD_VELOCITY ) {
                Log.i("Swipe Detector", "Left >>> Right");
                goToNextPage();
                return true;
            }

            // Swipe from left to right.
            // The swipe needs to exceed a certain distance (SWIPE_MIN_DISTANCE)
            // and a certain velocity (SWIPE_THRESHOLD_VELOCITY).
            if( e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs( velocityX ) > SWIPE_THRESHOLD_VELOCITY ) {
                Log.i("Swipe Detector", "Right >>> Left");
                goToPrevPage();
                return true;
            }

            return false;
        }
    }

    @Override
    public void onBackPressed() {
        if(ImageBox.instance != null){
            ImageBox.instance.closeBox(null);
            return;
        }

        moveTaskToBack(true);
        // code here to show dialog
        //super.onBackPressed();  // optional depending on your needs
    }

    @Override
    public void onPause() {
        super.onPause();

        for(int i = 0; i <= images.size() - 1; i++){
            if(images.get(i).getImageLoader().task != null)
                images.get(i).getImageLoader().task.cancel(true);
        }

        if(ShotDetails.getInstance().getImageLoader().task != null)
            ShotDetails.getInstance().getImageLoader().task.cancel(true);
    }

    @Override
    public void onResume(){
        super.onResume();

        for(int i = 0; i <= images.size() - 1; i++){
            images.get(i).setContext(this);
        }

        ShotDetails.getInstance().setContext(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}