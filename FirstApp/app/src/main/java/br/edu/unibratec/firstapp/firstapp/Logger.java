package br.edu.unibratec.firstapp.firstapp;

import android.util.Log;

public final class Logger {

    private Logger() {

    }

    public static void v(String message) {
        if (BuildConfig.DEBUG) {
            Log.v(Constants.APP_LOG_TAG, message);
        }
    }
}
