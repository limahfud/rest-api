package me.mahfud.restapi.activity.detail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*
import me.mahfud.restapi.R
import me.mahfud.restapi.activity.profile.ProfileActivity
import me.mahfud.restapi.api.ClientInstance
import me.mahfud.restapi.api.PostService
import me.mahfud.restapi.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private var userId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnDetailToProfile.setOnClickListener {
            val intent = Intent(this@DetailActivity, ProfileActivity::class.java)
            intent.putExtra("USER_ID", userId)
            startActivity(intent)
        }

        getDetail()
    }

    private fun getDetail() {
        val postService = ClientInstance.retrofit.create(PostService::class.java)

        val postId = intent.getIntExtra("POST_ID", 1)
        postService.getDetailPost(postId).enqueue(object: Callback<Post> {
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                val toast = Toast.makeText(this@DetailActivity, "Gagal mengambil data dari server", Toast.LENGTH_LONG)
                toast.show()
            }

            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                val body : Post? = response?.body()

                body?.let {
                    userId = body.userId
                    updatePostData(it)
                }
            }
        })
    }

    private fun updatePostData(post: Post) {
        tvDetailTitle.text = post.title
        tvDetailBody.text = post.body
    }
}
