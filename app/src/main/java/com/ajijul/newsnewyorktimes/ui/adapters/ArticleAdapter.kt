package com.ajijul.newsnewyorktimes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ajijul.newsnewyorktimes.databinding.ItemArticleBinding
import com.ajijul.newsnewyorktimes.ui.adapters.viewholders.NewsViewHolders
import com.ajijul.ny.news_feed.model.Result

class ArticleAdapter : RecyclerView.Adapter<NewsViewHolders>() {


    private val differCallBack = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {

            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {

            return newItem.equals(oldItem)
        }

    }


    var differList = AsyncListDiffer(this, differCallBack)
    private var onItemClickListener: ((Result) -> Unit)? = null
    fun setOnClickListener(listener: ((Result) -> Unit)) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolders {

        return NewsViewHolders(
            ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differList.currentList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolders, position: Int) {
        val article = differList.currentList[position]
        holder.bind(article)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(article)
            }
        }
    }


}