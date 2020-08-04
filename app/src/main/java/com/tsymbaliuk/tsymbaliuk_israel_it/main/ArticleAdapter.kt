package com.tsymbaliuk.tsymbaliuk_israel_it.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tsymbaliuk.tsymbaliuk_israel_it.R
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.ArticleModel

class ArticleAdapter(private val context: Context) : RecyclerView.Adapter<ArticleAdapter.MainViewHolder>() {

    var articleList = listOf<ArticleModel>()

    private lateinit var itemClickListener: (Int) -> Unit

    fun setItemClickListener(clickListener: (Int) -> Unit) {
        this.itemClickListener = clickListener
    }

    private lateinit var moreClickListener: (Int) -> Unit

    fun setMoreClickListener(clickListener: (Int) -> Unit) {
        this.moreClickListener = clickListener
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivNewsPhoto: ImageView = itemView.findViewById(R.id.ivNewsPhoto)
        val tvNewsSource: TextView = itemView.findViewById(R.id.tvNewsSource)
        val tvNewsTitle: TextView = itemView.findViewById(R.id.tvNewsTitle)
        val tvNewsTime: TextView = itemView.findViewById(R.id.tvNewsTime)
        val ivNewsMore: ImageView = itemView.findViewById(R.id.ivNewsMore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return MainViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val articlesList = articleList

        holder.itemView.setOnClickListener {
            if (::itemClickListener.isInitialized) {
                itemClickListener(position)
            }
        }
        loadDrawableTo(articlesList[position].photo, holder.ivNewsPhoto)
        holder.tvNewsSource.text = articlesList[position].source
        holder.tvNewsTitle.text = articlesList[position].title
        holder.tvNewsTime.text = articlesList[position].time
        holder.ivNewsMore.setOnClickListener {
            if (::moreClickListener.isInitialized) {
                moreClickListener(position)
            }
        }

    }

    private fun loadDrawableTo(uri: String?, imageView: ImageView) {
        Glide.with(context)
            .load(uri)
            .into(imageView)
    }

    fun updateData(newArticleList: List<ArticleModel>) {
        articleList = newArticleList
        notifyDataSetChanged()
    }

}