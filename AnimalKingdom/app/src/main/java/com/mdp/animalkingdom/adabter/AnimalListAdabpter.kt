package com.mdp.animalkingdom.adabter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mdp.animalkingdom.R

import com.mdp.animalkingdom.animal.Animal

class AnimalListAdabpter : ListAdapter<Animal, AnimalListAdabpter.AnimalViewHolder>(AnimalComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val habitat: TextView = itemView.findViewById(R.id.habitat)
        private val diet: TextView = itemView.findViewById(R.id.diet)

        fun bind(animal: Animal) {
            name.text =  animal.name
            habitat.text = animal.habitat
            diet.text = animal.diet
        }

        companion object {
            fun create(parent: ViewGroup): AnimalViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.animal_item, parent, false)
                return AnimalViewHolder(view)
            }
        }
    }

    class AnimalComparator : DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.diet == newItem
                .diet && oldItem.habitat == newItem.habitat
        }
    }
}