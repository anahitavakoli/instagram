package com.example.instagram.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import coil.load
import com.example.instagram.R
import com.example.instagram.models.Image
import com.example.instagram.util.Constants

class ImageAdapter(images: List<Image>): PagerAdapter() {

    var imageList = images

    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val imgData = imageList[position]
        val view: View = LayoutInflater.from(container.context).inflate(R.layout.image_row,null)
        val image = view.findViewById<AppCompatImageView>(R.id.img_indicator)
        image.load("${Constants.BASE_URL}/images/${imgData.img}")
        container.addView(view)
        return view
    }
}