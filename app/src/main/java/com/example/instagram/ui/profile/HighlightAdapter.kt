package com.example.instagram.ui.profile

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
import com.example.instagram.models.Highlight

class HighlightAdapter (cContext: Context, data: List<Highlight>) : RecyclerView.Adapter<HighlightAdapter.HighlightVH>() {

    var context = cContext
    var highlights = data


    class HighlightVH
        (itemView: View): RecyclerView.ViewHolder(itemView) {

        var imgHighlight= itemView.findViewById<AppCompatImageView>(R.id.img_highlight)
        var txtCategory = itemView.findViewById<AppCompatTextView>(R.id.txt_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighlightVH {
        var view: View = LayoutInflater.from(context).inflate(R.layout.highlight_row,null)
        return HighlightVH(view)
    }

    override fun onBindViewHolder(holder: HighlightVH, position: Int) {

        var highlight = highlights.get(position)

        holder.imgHighlight.load(highlight.image){
            transformations(CircleCropTransformation())
        }
        holder.txtCategory.setText(highlight.title)

//        holder.foodCard.setOnClickListener {
//            val intent = Intent(context, FoodActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            intent.putExtra("food", food)
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return highlights.size
    }
}