package com.example.diego.desafioandroid;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetJSON {

    private Context context;
    private JSONArray data;
    private RequestQueue queue;
    private String token = "&access_token=23d8c132e9e9b7fc887ec535b694c4324f0fa6ebbd3e5c8983aad18609d8fd1d";

    private static boolean loadFinished = false;

    public GetJSON(Context context){
        queue = Volley.newRequestQueue(context);
    }

    public JSONArray getData(){
        return data;
    }

    public boolean getStatus(){
        return loadFinished;
    }

    private void setData(JSONArray _data){
        data = _data;
        loadFinished = true;
    }

    public void loadData(int page){
        loadFinished = false;
        String url = "https://api.dribbble.com/v1/shots?page=" + page + token;

        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setData(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        queue.add(jsonRequest);
    }
}