package com.mdp.animalkingdom.animal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal")
data class Animal(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                  val name: String,
                  val habitat: String,
                  val diet: String){}
