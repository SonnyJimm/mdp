package com.example.project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AthleteAdabter(private val athleteList:ArrayList<AthletesModel>, private val context:Context):RecyclerView.Adapter<AthleteAdabter.AthleteAdapterViewHolder>() {
    class  AthleteAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val athleteName:TextView = itemView.findViewById(R.id.athleteName)
        val athleteSport:TextView =itemView.findViewById(R.id.athleteSport)
        val athleteCountry:TextView =itemView.findViewById(R.id.athleteCountry)
        val athleteBest:TextView = itemView.findViewById(R.id.athleteBest)
        val athletesMedals: TextView = itemView.findViewById(R.id.athleteMedals)
        val athletesFact:TextView = itemView.findViewById(R.id.athleteFacts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AthleteAdapterViewHolder {
        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.athlete_card,parent,false)
        return AthleteAdapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return athleteList.size
    }

    override fun onBindViewHolder(holder: AthleteAdapterViewHolder, position: Int) {
        holder.athleteSport.text = "Name: "+ athleteList[position].athleteSport
        holder.athleteName.text = "Sport: " + athleteList[position].athleteName
        holder.athleteCountry.text = "Country: " + athleteList[position].athleteCountry
        holder.athleteBest.text = "Best Performance: " + athleteList[position].athleteBest
        holder.athletesMedals.text = "Medals Awarded: " + athleteList[position].athletesMedals
        holder.athletesFact.text ="Facts: "+ athleteList[position].athletesFact
    }
}