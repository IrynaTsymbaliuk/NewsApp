package com.tsymbaliuk.tsymbaliuk_israel_it.press

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tsymbaliuk.tsymbaliuk_israel_it.R
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.SourceModel
import kotlin.math.min

class SourceAdapter : RecyclerView.Adapter<SourceAdapter.SourceViewHolder>() {

    var sourceList = arrayListOf<SourceModel>()

    private lateinit var itemClickListener: (Int) -> Unit

    fun setItemClickListener(clickListener: (Int) -> Unit) {
        this.itemClickListener = clickListener
    }

    private lateinit var addToFavoriteClickListener: (Int) -> Unit

    fun setAddToFavoriteClickListener(clickListener: (Int) -> Unit) {
        this.addToFavoriteClickListener = clickListener
    }

    inner class SourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNumber: TextView = itemView.findViewById(R.id.tvNumber)
        val ivSourcePhoto: ImageView = itemView.findViewById(R.id.ivSourcePhoto)
        val tvSourceName: TextView = itemView.findViewById(R.id.tvSourceName)
        val tvSourcePrice: TextView = itemView.findViewById(R.id.tvSourcePrice)
        val ivAddToSourceSubscriptions: ImageView = itemView.findViewById(R.id.ivAddToFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_source, parent, false)
        return SourceViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return min(sourceList.size, 5)
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            if (::itemClickListener.isInitialized) {
                itemClickListener(position)
            }
        }

        holder.tvNumber.text = (position + 1).toString()
        holder.tvSourceName.text = sourceList[position].name
        if (sourceList[position].isSubscribed == null || !sourceList[position].isSubscribed!!) {
            holder.ivAddToSourceSubscriptions.setImageResource(R.drawable.ic_star_border)
        } else holder.ivAddToSourceSubscriptions.setImageResource(R.drawable.ic_star)
        holder.ivAddToSourceSubscriptions.setOnClickListener {
            if (::addToFavoriteClickListener.isInitialized) {
                holder.ivAddToSourceSubscriptions.setImageResource(R.drawable.ic_star)
                addToFavoriteClickListener(position)
            }
        }

    }

    fun updateData(newSourceModelList: List<SourceModel>) {
        sourceList.clear()
        sourceList.addAll(newSourceModelList)
        notifyDataSetChanged()
    }

}