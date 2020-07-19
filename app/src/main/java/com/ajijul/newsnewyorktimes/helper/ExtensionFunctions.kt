package com.ajijul.newsnewyorktimes.helper

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.ajijul.newsnewyorktimes.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("image")
fun ImageView.setSleepImage(imgUrl: String?) {
    imgUrl?.let {
        Glide.with(context)
            .load(it)
            .into(this)
    }
}
