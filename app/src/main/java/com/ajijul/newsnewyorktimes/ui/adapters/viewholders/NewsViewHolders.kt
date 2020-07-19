package com.ajijul.newsnewyorktimes.ui.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ajijul.ny.news_feed.model.Result
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsViewHolders(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(article: Result) {
        itemView.apply {
            Glide.with(this).load(article.mediaImageUrl).into(ivArticleImage)
            tvSource.text = article.source
            tvTitle.text = article.title
            tvDescription.text = article.abstract
            tvPublishedAt.text = article.publishedDate
        }
    }
}