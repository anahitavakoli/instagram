package com.example.instagram.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.instagram.R
import com.example.instagram.models.Story

class StoryAdapter (cContext: Context, data: List<Story>) : RecyclerView.Adapter<StoryAdapter.StoryVH>() {

    var context = cContext
    var stories = data


    class StoryVH
        (itemView: View): RecyclerView.ViewHolder(itemView) {

        var imgStory= itemView.findViewById<AppCompatImageView>(R.id.img_story)
        var txtName = itemView.findViewById<AppCompatTextView>(R.id.txt_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryVH {
        var view: View = LayoutInflater.from(context).inflate(R.layout.story_row,null)
        return StoryVH(view)
    }

    override fun onBindViewHolder(holder: StoryVH, position: Int) {

        var story = stories.get(position)

        holder.imgStory.load(story.image){
            transformations(CircleCropTransformation())
        }
        holder.txtName.setText(story.title)

//        holder.foodCard.setOnClickListener {
//            val intent = Intent(context, FoodActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            intent.putExtra("food", food)
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return stories.size
    }
}