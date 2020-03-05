package com.pram.bookapivolley.api.service;

public class BookApiUrl {
    private static String BASE_URL = "https://ancient-brook-04057.herokuapp.com";

    public static final String getBooks = BASE_URL +"/books";
    public static final String getBook = BASE_URL +"/books/";
    public static final String createBook = BASE_URL +"/books";
    public static final String putBook = BASE_URL +"/books/";
    public static final String patchBook = BASE_URL +"/books/";
    public static final String removeBook = BASE_URL +"/books/";
}
