package com.example.wednesdayquiz.networkmanager

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FlickrService {
    private val flickr = Retrofit.Builder()
        .baseUrl(" https://www.flickr.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiFlickr = flickr.create(ApiService::class.java)
}