package com.ajijul.newsnewyorktimes.ui.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ajijul.newsnewyorktimes.databinding.ItemArticleBinding
import com.ajijul.ny.news_feed.model.Result
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article.view.*

class NewsViewHolders(var itemArticleBinding: ItemArticleBinding) : RecyclerView.ViewHolder(itemArticleBinding.root) {

    fun bind(article: Result) {
        itemArticleBinding.article = article
        itemArticleBinding.executePendingBindings()
//        itemView.apply {
//            Glide.with(this).load(article.mediaImageUrl).into(ivArticleImage)
//            tvSource.text = article.source
//            tvTitle.text = article.title
//
//            tvDescription.text = article.abstract
//            tvPublishedAt.text = article.publishedDate
//        }
    }
}