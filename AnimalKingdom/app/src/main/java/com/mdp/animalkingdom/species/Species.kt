package com.mdp.animalkingdom.species

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "species")
data class Species( @PrimaryKey(autoGenerate = true) val id: Int = 0, val name:String, val description:String)
