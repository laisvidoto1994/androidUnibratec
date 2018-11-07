package com.example.diego.desafioandroid;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.os.AsyncTask;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import java.io.File;

public class ImageLoader {

    public enum ImageLoadType{
        Circular,
        Normal
    }

    private static final String TAG  = "IMAGE_LOADER";

    private FutureTarget<File> image;
    public AsyncTask<Void, Void, Void> task;

    public ImageLoader() {
        task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                return null;
            }
        };
    }

    public ImageLoader(Context _context, int _width, int _height, String _url, ImageView _view, ImageLoadType _loadType) {

        final Context context = _context;
        final int width = _width;
        final int height = _height;
        final String url = _url;
        final ImageView view = _view;
        final ImageLoadType loadType = _loadType;

        task = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                if(isCancelled()) return null;

                image = Glide.with(context)
                                .load(url)
                                .downloadOnly(width, height);

                return null;
            }

            @Override
            protected void onPostExecute(Void dummy) {

                if (isCancelled()) {
                    Log.i(TAG, "Download Finished");
                    return;
                }

                if(loadType == ImageLoadType.Normal) {

                    Glide.with(context)
                            .load(url)
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .placeholder(R.drawable.placeholder)
                            .crossFade()
                            .into(view);
                } else {
                    Glide.with(context)
                            .load(url)
                            .asBitmap()
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new BitmapImageViewTarget(view) {
                                @Override
                                protected void setResource(Bitmap resource) {
                                    RoundedBitmapDrawable circularBitmapDrawable =
                                            RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                                    circularBitmapDrawable.setCircular(true);
                                    view.setImageDrawable(circularBitmapDrawable);
                                }
                            });
                }

                Log.i(TAG, "Image loaded");
                this.cancel(true);
            }
        }.execute();
    }
}
