package com.mdp.animalkingdom.adabter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mdp.animalkingdom.R
import com.mdp.animalkingdom.animal.Animal
import com.mdp.animalkingdom.species.Species

class SpeciesListAdabpter : ListAdapter<Species, SpeciesListAdabpter.SpeciesViewHolder>(SpeciesComparator()) {

    class SpeciesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val description: TextView = itemView.findViewById(R.id.description)

        fun bind(species: Species) {
            name.text = species.name
            description.text = species.description
        }

        companion object {
            fun create(parent: ViewGroup): SpeciesListAdabpter.SpeciesViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.species_item, parent, false)
                return SpeciesViewHolder(view)
            }
        }
    }
    class SpeciesComparator : DiffUtil.ItemCallback<Species>() {
        override fun areItemsTheSame(oldItem: Species, newItem: Species): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Species, newItem: Species): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.description == newItem.description

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewHolder {
        return SpeciesViewHolder.create(parent);
    }

    override fun onBindViewHolder(holder: SpeciesViewHolder, position: Int) {
        var current = getItem(position)
        holder.bind(current)
    }
}