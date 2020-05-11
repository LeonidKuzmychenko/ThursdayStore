package com.example.thursdaystore.retrofit;

class RetrofitApi {

    private final var URL = "http://ancient-bayou-56228.herokuapp.com"

    fun server(): ServerRequest = RetrofitCreator().get(URL).create(ServerRequest::class.java)

}