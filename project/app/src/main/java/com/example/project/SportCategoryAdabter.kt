package com.example.project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SportCategoryAdabter (
    private val categoryList : ArrayList<SportCategoryModel>,
    private val context : Context
) : RecyclerView.Adapter<SportCategoryAdabter.CategoryViewHolder>() {


    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val sportType:TextView = itemView.findViewById(R.id.sportType)
        val sportName:TextView =  itemView.findViewById(R.id.sportName)
        val sportInstruction:TextView =  itemView.findViewById(R.id.sportInstruction)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sport_categories,parent,false)
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.sportName.text = categoryList[position].sportName;
        holder.sportType.text = categoryList[position].sportType;
        holder.sportInstruction.text = categoryList[position].sportInstruction;
    }

}