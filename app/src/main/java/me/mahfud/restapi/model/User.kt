package me.mahfud.restapi.model

import com.google.gson.annotations.SerializedName

data class User(val id: Int,
                val name: String,
                val username: String,
                val email: String,
                val phone: String,
                val website: String,
                val company: Company,
                val address: Address)

data class Address(val street: String,
                   val suite: String,
                   val city: String,
                   val zipcode: String,
                   val geo: Geo)

data class Geo(@SerializedName("lat") val latitude: String,
               @SerializedName("lng") val longitude: String)

data class Company(val name: String,
                   val catchPhrase: String,
                   val bs: String)


