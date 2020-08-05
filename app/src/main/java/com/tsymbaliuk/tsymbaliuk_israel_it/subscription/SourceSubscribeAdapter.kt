package com.tsymbaliuk.tsymbaliuk_israel_it.subscription

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tsymbaliuk.domain.source.model.SourceModel
import com.tsymbaliuk.tsymbaliuk_israel_it.R

class SourceSubscribeAdapter(val context: Context) : RecyclerView.Adapter<SourceSubscribeAdapter.SubscribeSourceViewHolder>() {

    var sourceList = listOf<SourceModel>()

    private lateinit var itemClickListener: (Int) -> Unit

    fun setItemClickListener(clickListener: (Int) -> Unit) {
        this.itemClickListener = clickListener
    }

    private lateinit var moreClickListener: (Int) -> Unit

    fun setMoreClickListener(clickListener: (Int) -> Unit) {
        this.moreClickListener = clickListener
    }

    inner class SubscribeSourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSourceName = itemView.findViewById<TextView>(R.id.tvSourceName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscribeSourceViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_subscribe_source, parent, false)
        return SubscribeSourceViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return sourceList.size
    }

    override fun onBindViewHolder(holder: SubscribeSourceViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            if (::itemClickListener.isInitialized) {
                itemClickListener(position)
            }
        }
        holder.tvSourceName.text = sourceList[position].name/*
        holder.ivNewsMore.setOnClickListener {
            if (::moreClickListener.isInitialized) {
                moreClickListener(position)
            }
        }*/

    }

    fun loadDrawableTo(uri: String?, imageView: ImageView) {
        Glide.with(context)
            .load(uri)
            .into(imageView)
    }

    fun updateData(newSourceList: List<SourceModel>) {
        sourceList = newSourceList
        notifyDataSetChanged()
    }

}