package me.mahfud.restapi.activity.detail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import me.mahfud.restapi.R
import me.mahfud.restapi.activity.profile.ProfileActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnDetailToProfile.setOnClickListener {
            startActivity(Intent(this@DetailActivity, ProfileActivity::class.java))
        }
    }
}
