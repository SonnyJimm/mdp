package com.example.project

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class NewsAdapter(private val newsList:ArrayList<NewsModel>, private val context: Context): RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>() {


    class NewsAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val newsImage:ImageView = itemView.findViewById(R.id.newsBanner)
        val newsTitle:TextView = itemView.findViewById(R.id.newsTitle)
        val newsDescrtion:TextView = itemView.findViewById(R.id.newsDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_card,parent,false)
        return NewsAdapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        holder.newsTitle.text = newsList[position].title
        holder.newsDescrtion.text = newsList[position].description
        Glide.with(context).load(newsList[position].url).into(holder.newsImage)
    }
}