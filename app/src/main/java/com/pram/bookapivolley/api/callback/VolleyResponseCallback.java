package com.pram.bookapivolley.api.callback;

import com.android.volley.VolleyError;

public interface VolleyResponseCallback<T> {
    void onResponse(T response);
    void onErrorResponse(VolleyError error);
}
