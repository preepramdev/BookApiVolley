package com.pram.bookapivolley.api.controller;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.pram.bookapivolley.api.manager.HttpManager;
import com.pram.bookapivolley.api.callback.VolleyResponseCallback;
import com.pram.bookapivolley.api.service.BookApiService;
import com.pram.bookapivolley.api.service.BookApiUrl;
import com.pram.bookapivolley.manager.Contextor;
import com.pram.bookapivolley.model.Book;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class BookApiController {
    private static final String TAG = "BookApiController";

    Context mContext;
    RequestQueue mRequestQueue;

    public BookApiController() {
        mContext = Contextor.getInstance().getContext();
        mRequestQueue = HttpManager.getInstance(mContext).getRequestQueue();
    }

    public void getBooks(VolleyResponseCallback callback) {
        String name = new Throwable().getStackTrace()[0].getMethodName();
        int method = Request.Method.GET;
        String contentType = BookApiService.CONTENT_TYPE_JSON;
        String url = BookApiUrl.getBooks;
        final String body = "";

        Thread thread = new Thread() {
            @Override
            public void run() {
                JsonArrayRequest request = new JsonArrayRequest(method, url, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                callback.onResponse(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                callback.onErrorResponse(error);
                            }
                        }) {
                    @Override
                    public String getBodyContentType() {
                        return contentType;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return super.getHeaders();
                    }

                    @Override
                    public byte[] getBody() {
                        return body.getBytes();
                    }
                };
                BookApiService.connectionLogger(name, method, contentType, url, body);
                mRequestQueue.add(request);
            }
        };
        thread.start();
    }

    public void getBook(int bookId, VolleyResponseCallback callback) {
        String name = new Throwable().getStackTrace()[0].getMethodName();
        int method = Request.Method.GET;
        String contentType = BookApiService.CONTENT_TYPE_JSON;
        String url = BookApiUrl.getBook + bookId;
        final String body = "";
        Thread thread = new Thread() {
            @Override
            public void run() {
                JsonObjectRequest request = new JsonObjectRequest(method, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                callback.onResponse(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                callback.onErrorResponse(error);
                            }
                        }) {
                    @Override
                    public String getBodyContentType() {
                        return contentType;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return super.getHeaders();
                    }

                    @Override
                    public byte[] getBody() {
                        return body.getBytes();
                    }
                };
                BookApiService.connectionLogger(name, method, contentType, url, body);
                mRequestQueue.add(request);
            }
        };
        thread.start();
    }

    public void createBook(Book book, VolleyResponseCallback callback) {
        String name = new Throwable().getStackTrace()[0].getMethodName();
        int method = Request.Method.POST;
        String contentType = BookApiService.CONTENT_TYPE_JSON;
        String url = BookApiUrl.createBook;
        final String body = "\n" +
                "{\n" +
                "    \"title\": \"" + book.getTitle() + "\",\n" +
                "    \"author\": \"" + book.getAuthor() + "\",\n" +
                "    \"pages\": " + book.getPages() + "\n" +
                "}";
        Thread thread = new Thread() {
            @Override
            public void run() {
                JsonObjectRequest request = new JsonObjectRequest(method, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                callback.onResponse(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                callback.onErrorResponse(error);
                            }
                        }) {
                    @Override
                    public String getBodyContentType() {
                        return contentType;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return super.getHeaders();
                    }

                    @Override
                    public byte[] getBody() {
                        return body.getBytes();
                    }
                };
                BookApiService.connectionLogger(name, method, contentType, url, body);
                mRequestQueue.add(request);
            }
        };
        thread.start();
    }

    public void updatePutBook(Book book, VolleyResponseCallback callback) {
        String name = new Throwable().getStackTrace()[0].getMethodName();
        int method = Request.Method.PUT;
        String contentType = BookApiService.CONTENT_TYPE_JSON;
        String url = BookApiUrl.putBook + book.getId();
        final String body = "\n" +
                "{\n" +
                "    \"title\": \"" + book.getTitle() + "\",\n" +
                "    \"author\": \"" + book.getAuthor() + "\",\n" +
                "    \"pages\": " + book.getPages() + "\n" +
                "}";
        Thread thread = new Thread() {
            @Override
            public void run() {
                JsonObjectRequest request = new JsonObjectRequest(method, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                callback.onResponse(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                callback.onErrorResponse(error);
                            }
                        }) {
                    @Override
                    public String getBodyContentType() {
                        return contentType;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return super.getHeaders();
                    }

                    @Override
                    public byte[] getBody() {
                        return body.getBytes();
                    }
                };
                BookApiService.connectionLogger(name, method, contentType, url, body);
                mRequestQueue.add(request);
            }
        };
        thread.start();
    }

    public void updatePatchBook(Book book, VolleyResponseCallback callback) {
        String name = new Throwable().getStackTrace()[0].getMethodName();
        int method = Request.Method.PATCH;
        String contentType = BookApiService.CONTENT_TYPE_JSON;
        String url = BookApiUrl.patchBook + book.getId();
        final String body = "\n" +
                "{\n" +
                "    \"title\": \"" + book.getTitle() + "\",\n" +
                "    \"author\": \"" + book.getAuthor() + "\",\n" +
                "    \"pages\": " + book.getPages() + "\n" +
                "}";
        Thread thread = new Thread() {
            @Override
            public void run() {
                JsonObjectRequest request = new JsonObjectRequest(method, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                callback.onResponse(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                callback.onErrorResponse(error);
                            }
                        }) {
                    @Override
                    public String getBodyContentType() {
                        return contentType;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return super.getHeaders();
                    }

                    @Override
                    public byte[] getBody() {
                        return body.getBytes();
                    }
                };
                BookApiService.connectionLogger(name, method, contentType, url, body);
                mRequestQueue.add(request);
            }
        };
        thread.start();
    }

    public void removeBook(int bookId, VolleyResponseCallback callback) {
        String name = new Throwable().getStackTrace()[0].getMethodName();
        int method = Request.Method.DELETE;
        String contentType = BookApiService.CONTENT_TYPE_JSON;
        String url = BookApiUrl.getBook + bookId;
        final String body = "";
        Thread thread = new Thread() {
            @Override
            public void run() {
                JsonObjectRequest request = new JsonObjectRequest(method, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                callback.onResponse(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                callback.onErrorResponse(error);
                            }
                        }) {
                    @Override
                    public String getBodyContentType() {
                        return contentType;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return super.getHeaders();
                    }

                    @Override
                    public byte[] getBody() {
                        return body.getBytes();
                    }
                };
                BookApiService.connectionLogger(name, method, contentType, url, body);
                mRequestQueue.add(request);
            }
        };
        thread.start();
    }
}
