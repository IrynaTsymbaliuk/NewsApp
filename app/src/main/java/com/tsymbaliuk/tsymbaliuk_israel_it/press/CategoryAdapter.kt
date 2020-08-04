package com.tsymbaliuk.tsymbaliuk_israel_it.press

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tsymbaliuk.tsymbaliuk_israel_it.R

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var categoryList = listOf(
        "business",
        "entertainment",
        "general",
        "health",
        "science",
        "sports",
        "technology")

    private lateinit var itemClickListener: (Int) -> Unit

    fun setItemClickListener(clickListener: (Int) -> Unit) {
        this.itemClickListener = clickListener
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCategoryPhoto: ImageView = itemView.findViewById<ImageView>(R.id.ivCategoryPhoto)
        val tvCategoryTitle: TextView = itemView.findViewById<TextView>(R.id.tvCategoryTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            if (::itemClickListener.isInitialized) {
                itemClickListener(position)
            }
        }

        holder.tvCategoryTitle.text = categoryList[position]

    }

}