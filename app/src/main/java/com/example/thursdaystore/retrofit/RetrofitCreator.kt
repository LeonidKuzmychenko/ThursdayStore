package com.example.thursdaystore.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

class RetrofitCreator {
    companion object{
        fun get(url:String): Retrofit =
            Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}