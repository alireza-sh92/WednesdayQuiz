package com.example.wednesdayquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wednesdayquiz.viewmodels.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model: MyViewModel by viewModels()
        val listV = findViewById<ListView>(R.id.listView)
        val imageV = findViewById<ImageView>(R.id.imageView)
        listView = findViewById<ListView>(R.id.listView)
        val textView = findViewById<TextView>(R.id.textView)
        var linklist:MutableList<String> = mutableListOf(model._imagesLiveDara.observe(
            this,
            Observer {
                it.map { it ->
                    it
                }
            }
        ).toString()
        )

    }
}




