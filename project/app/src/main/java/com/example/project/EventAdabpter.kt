package com.example.project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdabpter(private val eventList:ArrayList<EventModel>, private val context: Context):RecyclerView.Adapter<EventAdabpter.EvebtAdabterViewHolder>() {

    class EvebtAdabterViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val eventName:TextView = itemView.findViewById(R.id.eventName)
        val eventDate:TextView = itemView.findViewById(R.id.eventDate)
        val eventDesctiption:TextView = itemView.findViewById(R.id.eventDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvebtAdabterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_card,parent,false)
        return EvebtAdabterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    override fun onBindViewHolder(holder: EvebtAdabterViewHolder, position: Int) {
        holder.eventName.text = eventList[position].eventName
        holder.eventDate.text = eventList[position].eventDate
        holder.eventDesctiption.text = eventList[position].eventDescription
    }
}