package com.example.diego.desafioandroid;


import android.content.Context;
import android.content.res.TypedArray;

public final class Utility {

    private static Context context;

    private Utility(){}

    public static void Init(Context _context) {
        context = _context;
    }

    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getActionBarHeight() {
        TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[] { android.R.attr.actionBarSize });
        int mActionBarSize = (int) styledAttributes.getDimension(0, 0);
        //styledAttributes.recycle();

        return mActionBarSize;
    }

    public static int convertDpToPx(int value) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (value * scale + 0.5f);
    }
}
