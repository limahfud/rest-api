package me.mahfud.restapi.api

import me.mahfud.restapi.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("/posts")
    fun getAllPost() : Call<List<Post>>
}