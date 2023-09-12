package com.example.instagram.ui.profile.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import coil.load
import coil.transform.CircleCropTransformation
import com.example.instagram.R
import com.example.instagram.models.Post
import com.example.instagram.ui.home.ImageAdapter
import com.example.instagram.ui.home.PostAdapter
import com.example.instagram.util.Constants

class UserPostsAdapter (listPosts: List<Post>): RecyclerView.Adapter<UserPostsAdapter.UserPostVH>() {

    var postList = listPosts

    class UserPostVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPost = itemView.findViewById<AppCompatImageView>(R.id.img_userPost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostVH {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.user_post_row,null)
        return UserPostVH(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: UserPostVH, position: Int) {
        val post = postList[position]
        holder.imgPost.load("${Constants.BASE_URL}images/${post.images[0].img}")
    }
}