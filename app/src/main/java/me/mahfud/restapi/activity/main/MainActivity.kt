package me.mahfud.restapi.activity.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
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


        val posts = listOf<Post>()

        displayPostData(posts)

        getListPost()
    }

    private fun getListPost() {
        val postService = ClientInstance.retrofit.create(PostService::class.java)
        postService.getAllPost().enqueue(object: Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                val toast = Toast.makeText(this@MainActivity, "Gagal mengambil data dari server", Toast.LENGTH_LONG)
                toast.show()
            }

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                val posts = response?.body()

                if (posts != null) {
                    displayPostData(posts)
                }
            }
        })
    }

    private fun displayPostData(posts: List<Post>) {
        val adapter = ListPostAdapter(posts)

        rvListPost.layoutManager = LinearLayoutManager(this)
        rvListPost.adapter = adapter
    }
}
