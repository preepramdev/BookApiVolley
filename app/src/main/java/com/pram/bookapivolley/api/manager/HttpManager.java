package com.pram.bookapivolley.api.manager;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class HttpManager {
    private static HttpManager mInstance;
    private RequestQueue mRequestQueue;

    private HttpManager(Context context) {
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized HttpManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new HttpManager(context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}
