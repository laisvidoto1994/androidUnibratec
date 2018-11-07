package com.unibratec.laisvidoto.applicationexemplo.util;

import com.unibratec.laisvidoto.applicationexemplo.interfaces.Services;

/**
 * Created by Laís Vidoto on 02/11/2017.
 */

public class Api
{
    public static final String BASE_URL = "https://api.github.com";

    public static Services getGitService()
    {
        return RetrofitClient.getClient(BASE_URL).create(Services.class);
    }
}
