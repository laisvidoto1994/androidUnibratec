package com.example.diego.desafioandroid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ImageBox {

    public static ImageBox instance;
    private Shot shot;

    private Context context;
    private int widthInDp;
    private int heightInDp;
    private int openHeightInDp;

    private CustomScrollView scrollView;
    private RelativeLayout container;
    private ImageView backgroundImage;
    private RelativeLayout titleContainer;
    private TextView titleText;
    private TextView viewsText;
    private ImageView viewsImage;
    private LinearLayout socialContainer;
    private ImageButton facebookButton;
    private ImageButton twitterButton;
    private ImageButton instagramButton;
    private ImageButton dribbbleButton;

    private boolean isExpanded;
    private static boolean hasOpenShot = false;
    private ImageLoader imageLoader;

    public ImageBox(Context _context, CustomScrollView _scrollView, Shot _shot){
        Init(_context, _scrollView);

        loadInfo(_shot);
    }

    public ImageBox(Context _context, CustomScrollView _scrollView){
        Init(_context, _scrollView);
    }

    public ImageBox(Context _context){
        Init(_context, null);
    }

    public RelativeLayout getContainer(){
        return container;
    }

    private void Init(Context _context, CustomScrollView _scrollView){
        context = _context;
        scrollView = _scrollView;
        isExpanded = false;

        widthInDp = 325;
        heightInDp = 245;
        openHeightInDp = 505;

        container = new RelativeLayout(context);
        container.setId(View.generateViewId());
        container.setBackgroundColor(Color.WHITE);

        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(Utility.convertDpToPx(widthInDp), Utility.convertDpToPx(heightInDp));
        linearParams.gravity = Gravity.CENTER_HORIZONTAL;
        linearParams.topMargin = Utility.convertDpToPx(2);
        linearParams.bottomMargin = Utility.convertDpToPx(3);

        container.setLayoutParams(linearParams);

        if(scrollView != null) {

            createBackgroundImage();
            createTitleContainer();
            createSocialContainer();
            createSocialButtons();

            backgroundImage.setOnClickListener(expandBox());
        }
    }

    public void setContext(Context _context){
        context = _context;
    }

    public void insertContainerInto(LinearLayout _container){
        _container.addView(container);
    }

    public void loadInfo(Shot _shot){
        shot = _shot;

        String toLoad = shot.images.hidpi != null ? shot.images.hidpi : shot.images.normal;
        loadImage(toLoad);
        titleText.setText(shot.title);
        viewsText.setText(String.valueOf(shot.views_count));
    }

    private void loadImage(String _url){
        imageLoader = new ImageLoader(context, Utility.convertDpToPx(widthInDp), Utility.convertDpToPx(heightInDp), _url, backgroundImage, ImageLoader.ImageLoadType.Normal);
    }

    public ImageLoader getImageLoader(){
        return imageLoader;
    }

    private void createBackgroundImage() {
        if(backgroundImage != null) return;

        backgroundImage = new ImageView(context);
        backgroundImage.setId(View.generateViewId());
        backgroundImage.setBackgroundColor(context.getResources().getColor(R.color.very_dark_gray_color));

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(Utility.convertDpToPx(widthInDp), Utility.convertDpToPx(heightInDp));
        relativeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        container.addView(backgroundImage, relativeParams);
    }

    private void createTitleContainer(){
        if(titleContainer != null) return;

        titleContainer = new RelativeLayout(context);
        titleContainer.setId(View.generateViewId());
        titleContainer.setBackgroundColor(Color.argb(150, 80, 80, 80));

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, Utility.convertDpToPx(45));
        relativeParams.addRule(RelativeLayout.ALIGN_BOTTOM, backgroundImage.getId());

        createTitleText();
        createViewCounts();

        container.addView(titleContainer, relativeParams);
    }

    private void createTitleText(){
        if(titleText != null) return;

        titleText = new TextView(context);
        titleText.setTextSize(18);
        titleText.setTextColor(Color.WHITE);
        titleText.setEllipsize(TextUtils.TruncateAt.END);
        titleText.setSingleLine(true);

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(Utility.convertDpToPx(230), RelativeLayout.LayoutParams.WRAP_CONTENT);
        relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        relativeParams.addRule(RelativeLayout.CENTER_VERTICAL);
        relativeParams.leftMargin = Utility.convertDpToPx(7);

        titleContainer.addView(titleText, relativeParams);
    }

    private void createViewCounts(){
        if(viewsText != null || viewsImage != null) return;

        viewsText = new TextView(context);
        viewsText.setId(View.generateViewId());
        viewsText.setTextSize(18);
        viewsText.setTextColor(Color.WHITE);

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        relativeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        relativeParams.addRule(RelativeLayout.CENTER_VERTICAL);
        relativeParams.rightMargin = Utility.convertDpToPx(7);

        titleContainer.addView(viewsText, relativeParams);

        Drawable drawable = context.getResources().getDrawable(R.drawable.view_icon);
        viewsImage = new ImageView(context);
        viewsImage.setImageDrawable(drawable);
        viewsImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        relativeParams = new RelativeLayout.LayoutParams(Utility.convertDpToPx(20), Utility.convertDpToPx(45));
        relativeParams.addRule(RelativeLayout.LEFT_OF, viewsText.getId());
        relativeParams.addRule(RelativeLayout.CENTER_VERTICAL);
        relativeParams.rightMargin = Utility.convertDpToPx(7);

        titleContainer.addView(viewsImage, relativeParams);
    }

    private void createSocialContainer(){
        if(socialContainer != null) return;

        GradientDrawable shape =  new GradientDrawable();
        shape.setCornerRadius(30);

        socialContainer = new LinearLayout(context);
        socialContainer.setOrientation(LinearLayout.HORIZONTAL);
        shape.setColor(Color.argb(20, 255, 255, 255));
        socialContainer.setBackground(shape);

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, Utility.convertDpToPx(45));
        relativeParams.addRule(RelativeLayout.ABOVE, titleContainer.getId());
        relativeParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        relativeParams.bottomMargin = Utility.convertDpToPx(2);

        container.addView(socialContainer, relativeParams);
    }

    private void createSocialButtons(){
        if(facebookButton != null || twitterButton != null || instagramButton != null || dribbbleButton != null) return;

        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);

        Drawable drawable = context.getResources().getDrawable(R.drawable.facebook_icon);
        facebookButton = new ImageButton(context);
        facebookButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        facebookButton.setImageDrawable(drawable);
        facebookButton.setBackgroundColor(Color.argb(0, 0, 0, 0));
        socialContainer.addView(facebookButton, linearParams);

        drawable = context.getResources().getDrawable(R.drawable.twitter_icon);
        twitterButton = new ImageButton(context);
        twitterButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        twitterButton.setImageDrawable(drawable);
        twitterButton.setBackgroundColor(Color.argb(0, 0, 0, 0));
        socialContainer.addView(twitterButton, linearParams);

        drawable = context.getResources().getDrawable(R.drawable.instagram_icon);
        instagramButton = new ImageButton(context);
        instagramButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        instagramButton.setImageDrawable(drawable);
        instagramButton.setBackgroundColor(Color.argb(0, 0, 0, 0));
        socialContainer.addView(instagramButton, linearParams);

        drawable = context.getResources().getDrawable(R.drawable.dribbble_icon);
        dribbbleButton = new ImageButton(context);
        dribbbleButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        dribbbleButton.setImageDrawable(drawable);
        dribbbleButton.setBackgroundColor(Color.argb(0, 0, 0, 0));
        socialContainer.addView(dribbbleButton, linearParams);
    }

    public void clearImage(){
        Glide.clear(backgroundImage);
    }

    private View.OnClickListener expandBox() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isExpanded){
                    closeBox(v);
                } else{
                    openBox(v);
                }
            }
        };
    }

    private void openBox(View v){

        if(hasOpenShot) return;
        hasOpenShot = true;

        instance = this;

        int[] pos = {0, 0};
        v.getLocationOnScreen(pos);
        View viewParent = (View)v.getParent();

        ShotDetails.getInstance().clearImage();
        ShotDetails.getInstance().setData(shot, backgroundImage.getId());

        isExpanded = true;
        scrollView.customSmoothScrollTo(0, pos[1] + scrollView.getScrollY() - Utility.getStatusBarHeight() - Utility.getActionBarHeight());
        scrollView.setScrollingEnabled(false);
        int targetHeight = Utility.convertDpToPx(openHeightInDp);

        ResizeAnimation resAnim = new ResizeAnimation(viewParent, targetHeight);
        resAnim.setDuration(500);
        resAnim.setAnimationListener(animationListener());
        viewParent.startAnimation(resAnim);
    }

    public void closeBox(View v){

        instance = null;

        int[] pos = {0, 0};

        if(v == null) {
            v = backgroundImage;
        }

        v.getLocationOnScreen(pos);
        View viewParent = (View) v.getParent();

        hasOpenShot = false;
        isExpanded = false;
        scrollView.setScrollingEnabled(true);
        int targetHeight = Utility.convertDpToPx(heightInDp);

        ResizeAnimation resAnim = new ResizeAnimation(viewParent, targetHeight);
        resAnim.setDuration(500);
        resAnim.setAnimationListener(animationListener());
        viewParent.startAnimation(resAnim);
    }

    private Animation.AnimationListener animationListener(){
        return new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {

                if(isExpanded){
                    ShotDetails.getInstance().insertContainerAt(container);
                    ShotDetails.getInstance().getContainer().animate().alpha(1f).start();
                } else {
                    ShotDetails.getInstance().getImageLoader().task.cancel(true);
                    ShotDetails.getInstance().clearImage();
                    ShotDetails.getInstance().removeContainerFrom(container);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        };
    }
}