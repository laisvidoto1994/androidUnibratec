package br.edu.unibratec.firstapp.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1001;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.v("MainActivity - onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.new_activity_btn);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(Constants.EXTRA_01, getString(R.string.second_activity));
//                startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            String param = data.getStringExtra(Constants.EXTRA_02);
            Toast.makeText(this, "O parametro retornado foi = " + param, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        Logger.v("MainActivity - onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Logger.v("MainActivity - onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Logger.v("MainActivity - onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Logger.v("MainActivity - onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Logger.v("MainActivity - onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Logger.v("MainActivity - onDestroy");
        super.onDestroy();
    }
}
