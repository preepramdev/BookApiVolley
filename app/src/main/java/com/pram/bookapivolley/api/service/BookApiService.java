package com.pram.bookapivolley.api.service;

import android.util.Log;

import com.android.volley.Request;

public class BookApiService {
    private static final String TAG = "BookApiService";

    //contentType
    //header
    //logger

    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";

    public static void connectionLogger(String name, int method, String contentType,String url, String body) {
        String methodName = "";
        switch (method) {
            case Request.Method.GET:
                methodName = "GET";
                break;
            case Request.Method.POST:
                methodName = "POST";
                break;
            case Request.Method.PUT:
                methodName = "PUT";
                break;
            case Request.Method.PATCH:
                methodName = "PATCH";
                break;
            case Request.Method.DELETE:
                methodName = "DELETE";
                break;
        }

        Log.e(TAG, "connectionLogger: -->");
        Log.e(TAG, "connectionLogger: name --> " + name);
        Log.e(TAG, "connectionLogger: method --> " + methodName);
        Log.e(TAG, "connectionLogger: contentType --> " + contentType);
        Log.e(TAG, "connectionLogger: url --> " + url);
        Log.e(TAG, "connectionLogger: body --> " + body);
        Log.e(TAG, "connectionLogger: <--");
    }

    //withHeader
    public static void connectionLogger(String name, int method, String header,String contentType,String url, String body) {
        String methodName = "";
        switch (method) {
            case Request.Method.GET:
                methodName = "GET";
                break;
            case Request.Method.POST:
                methodName = "POST";
                break;
            case Request.Method.PUT:
                methodName = "PUT";
                break;
            case Request.Method.PATCH:
                methodName = "PATCH";
                break;
            case Request.Method.DELETE:
                methodName = "DELETE";
                break;
        }

        Log.e(TAG, "connectionLogger: name => " + name);
        Log.e(TAG, "connectionLogger: method => " + methodName);
        Log.e(TAG, "connectionLogger: header => " + header);
        Log.e(TAG, "connectionLogger: contentType => " + contentType);
        Log.e(TAG, "connectionLogger: url => " + url);
        Log.e(TAG, "connectionLogger: body => " + body);
    }
}
