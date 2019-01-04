package me.mahfud.restapi.activity.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import me.mahfud.restapi.R
import me.mahfud.restapi.api.ClientInstance
import me.mahfud.restapi.api.PostService
import me.mahfud.restapi.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val posts = listOf(Post(1, 2, "Hahaha", "Hihishi"),
                Post(1, 2, "Hahaha", "Hihishi"),
                Post(1, 2, "Hahaha", "Hihishi"))


        val adapter = ListPostAdapter(posts)

        rvListPost.layoutManager = LinearLayoutManager(this)
        rvListPost.adapter = adapter
    }
}
