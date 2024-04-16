package com.example.project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdabpter(private val historyList:ArrayList<HistoricalModel>, private val context: Context): RecyclerView.Adapter<HistoryAdabpter.HistoryAdabpterViewHolder>() {

    class HistoryAdabpterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val historyName:TextView = itemView.findViewById(R.id.historyName)
        val historyDate:TextView = itemView.findViewById(R.id.historyDate)
        val historyDesciption:TextView = itemView.findViewById(R.id.historyDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdabpterViewHolder {
        val holder = LayoutInflater.from(parent.context).inflate(R.layout.historical_card,parent,false)
        return HistoryAdabpterViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: HistoryAdabpterViewHolder, position: Int) {
        holder.historyName.text = historyList[position].historyName
        holder.historyDate.text = historyList[position].historyDate
        holder.historyDesciption.text = historyList[position].historyDescrption
    }
}