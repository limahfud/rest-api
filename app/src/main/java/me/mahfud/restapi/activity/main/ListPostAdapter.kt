package me.mahfud.restapi.activity.main

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_item_single_post.view.*
import me.mahfud.restapi.R
import me.mahfud.restapi.activity.detail.DetailActivity
import me.mahfud.restapi.model.Post

class ListPostAdapter(var posts : List<Post>) : RecyclerView.Adapter<ListPostAdapter.ListPostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPostHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_single_post, parent, false)

        return ListPostHolder(v)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(postHolder: ListPostHolder, position: Int) {
        postHolder.bind(posts[position])
    }

    fun updateData(posts: List<Post>) {
        this.posts = posts
    }


    class ListPostHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: Post) {
            view.tvSinglePostTitle.text = post.title
            view.tvSinglePostBody.text = post.body
            view.setOnClickListener {
                view.context.apply {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("POST_ID", post.id)

                    startActivity(intent)

                }
            }
        }
    }

}