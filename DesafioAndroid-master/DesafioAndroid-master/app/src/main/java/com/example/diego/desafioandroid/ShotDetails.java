package com.example.diego.desafioandroid;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public final class ShotDetails {

    private static ShotDetails instance;

    private static Context context;

    private LinearLayout container;
    private static LinearLayout userContainer;
    private static ImageView userImg;
    private static TextView userName;
    private static ScrollView detailContainer;
    private static TextView detailText;

    private static ImageLoader imageLoader;

    private ShotDetails(Context _context) {
        context = _context;
        imageLoader = new ImageLoader();

        container = new LinearLayout(context);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setAlpha(0);

        userContainer = new LinearLayout(context);
        userContainer.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utility.convertDpToPx(45));
        container.addView(userContainer, linearParams);

        userImg = new ImageView(context);
        userImg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        linearParams = new LinearLayout.LayoutParams(Utility.convertDpToPx(45), Utility.convertDpToPx(45));
        linearParams.leftMargin = Utility.convertDpToPx(7);
        userContainer.addView(userImg, linearParams);

        userName = new TextView(context);
        userName.setTextColor(context.getResources().getColor(R.color.very_dark_gray_color));
        userName.setTextSize(20);
        linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearParams.gravity = Gravity.CENTER;
        linearParams.leftMargin = Utility.convertDpToPx(30);
        userContainer.addView(userName, linearParams);

        detailContainer = new ScrollView(context);
        detailContainer.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS);
        linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearParams.topMargin = Utility.convertDpToPx(10);
        linearParams.leftMargin = Utility.convertDpToPx(7);
        linearParams.rightMargin = Utility.convertDpToPx(7);
        linearParams.weight = 1;
        container.addView(detailContainer, linearParams);

        detailText = new TextView(context);
        detailText.setTextColor(context.getResources().getColor(R.color.very_dark_gray_color));
        detailText.setTextSize(16);
        detailText.setMovementMethod(LinkMovementMethod.getInstance());
        linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        detailContainer.addView(detailText, linearParams);
    }

    public static synchronized void Init(Context _context) {
        if (instance == null) {
            instance = new ShotDetails(_context);
        }
    }

    public static ShotDetails getInstance(){
        return instance;
    }

    public void setData(Shot _shot, int _alignTo){

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(Utility.convertDpToPx(325), ViewGroup.LayoutParams.WRAP_CONTENT);
        relativeParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        relativeParams.addRule(RelativeLayout.BELOW, _alignTo);
        relativeParams.topMargin = Utility.convertDpToPx(10);
        container.setLayoutParams(relativeParams);

        imageLoader = new ImageLoader(context, Utility.convertDpToPx(40), Utility.convertDpToPx(40), _shot.user.avatar_url, userImg, ImageLoader.ImageLoadType.Circular);
        userName.setText(_shot.user.name);

        if(_shot.description != null)
            detailText.setText(Html.fromHtml(_shot.description));
    }

    public LinearLayout getContainer(){
        return container;
    }

    public ImageLoader getImageLoader(){
        return imageLoader;
    }

    public void setContext(Context _context){
        context = _context;
    }

    public void insertContainerAt(RelativeLayout _layout){
        container.setVisibility(View.VISIBLE);
        _layout.addView(container);
    }

    public void removeContainerFrom(RelativeLayout _layout) {
        container.setVisibility(View.GONE);
        _layout.removeView(container);
    }

    public void clearImage(){
        Glide.clear(userImg);
    }
}