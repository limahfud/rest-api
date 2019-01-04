package me.mahfud.restapi.api

import me.mahfud.restapi.model.Post
import me.mahfud.restapi.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("/posts")
    fun getAllPost() : Call<List<Post>>

    @GET("/posts/{postId}")
    fun getDetailPost(@Path("postId") postId: Int) : Call<Post>

    @GET("/users/{userId}")
    fun getDetailUser(@Path("userId") userId: Int) : Call<User>
}