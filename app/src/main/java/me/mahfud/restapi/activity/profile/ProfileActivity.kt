package me.mahfud.restapi.activity.profile

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*
import me.mahfud.restapi.R
import me.mahfud.restapi.api.ClientInstance
import me.mahfud.restapi.api.PostService
import me.mahfud.restapi.model.Post
import me.mahfud.restapi.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        getUserProfile()
    }

    private fun getUserProfile() {

        val userId = intent.getIntExtra("USER_ID", 1)

        val postService = ClientInstance.retrofit.create(PostService::class.java)
        postService.getDetailUser(userId).enqueue(object: Callback<User> {


            override fun onFailure(call: Call<User>?, t: Throwable?) {
                val toast = Toast.makeText(this@ProfileActivity, "Gagal mengambil data dari server", Toast.LENGTH_LONG)
                toast.show()
            }

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                val user = response?.body()

                user?.let { displayUserData(user) }
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun displayUserData(user: User) {
        tvProfileName.text = user.name
        tvProfileEmail.text = user.email
        tvProfileUsername.text = user.username

        tvProfilePhone.text = user.phone
        tvProfileWebsite.text = user.website
        tvProfileCompany.text = user.company.name

        val address = user.address
        tvProfileAddress.text = "${address.street} ${address.suite} ${address.city}. Zip Code : ${address.zipcode}"


    }
}
