package com.example.wednesdayquiz.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wednesdayquiz.networkmanager.FlickrService
import com.example.wednesdayquiz.networkmanager.flickrclass.Flickr
import com.example.wednesdayquiz.networkmanager.flickrclass.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel:ViewModel() {
    companion object{
        const val TAG = "VIEW MODEL"
    }
    private val imagesLiveData = MutableLiveData<List<String>>()
    val _imagesLiveDara: MutableLiveData<List<String>> = imagesLiveData
    var urlList:MutableList<String> = mutableListOf()
    init {
        FlickrService.apiFlickr.listOfImage(
            queryMap = mapOf(
            "api_key" to "1c04e05bce6e626247758d120b372a73",
            "method" to "flickr.photos.getPopular",
            "user_id" to "34427466731@N01",
            "extras" to "url_s",
            " format" to "json",
            "nojsoncallback" to "1",
            "per_page" to "100",
            "page" to "1")
        )
            .enqueue(object : Callback<Flickr>{
                override fun onResponse(call: Call<Flickr>, response: Response<Flickr>) {
                    response.body()?.photos?.photo?.map {
                        urlList.add(it.url_s)
                    }
                    Log.d(TAG,urlList.toString())
                    imagesLiveData.postValue(urlList)

                }

                override fun onFailure(call: Call<Flickr>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message.toString()}")
                }
            })
    }

}