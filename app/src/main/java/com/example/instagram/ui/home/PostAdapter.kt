package com.example.instagram.ui.home

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
import com.example.instagram.util.Constants

class PostAdapter(listPosts: List<Post>): RecyclerView.Adapter<PostAdapter.PostVH>() {

    var postList = listPosts

    class PostVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProfile = itemView.findViewById<AppCompatImageView>(R.id.img_profile)
        val txtUsername = itemView.findViewById<AppCompatTextView>(R.id.txt_username)
        val viewPager = itemView.findViewById<ViewPager>(R.id.viewpager)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.post_row,null)
        return PostVH(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostVH, position: Int) {
        val post = postList[position]
        holder.txtUsername.setText(post.username)
        holder.imgProfile.load("${Constants.BASE_URL}${post.imageProfile}"){
            transformations(CircleCropTransformation())
        }
        holder.viewPager.adapter = ImageAdapter(post.images)
    }
}