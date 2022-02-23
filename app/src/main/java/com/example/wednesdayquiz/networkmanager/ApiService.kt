package com.example.wednesdayquiz.networkmanager

import android.content.ClipData.Item
import com.example.wednesdayquiz.networkmanager.flickrclass.Flickr
import retrofit2.Call
import retrofit2.http.*
import java.util.stream.Collectors.toMap


interface ApiService {
    @GET("services/rest/")
    fun listOfImage(@QueryMap()queryMap:Map<String,String>):Call<Flickr>

}
