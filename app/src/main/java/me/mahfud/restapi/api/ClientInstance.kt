package me.mahfud.restapi.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientInstance {

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val retrofit: Retrofit by lazy {
            return@lazy Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }





}