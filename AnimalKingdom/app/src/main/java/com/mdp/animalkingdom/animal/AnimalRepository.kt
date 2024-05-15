package com.mdp.animalkingdom.animal

import android.util.Log
import android.widget.Toast
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count

class AnimalRepository(private val animalDAO: AnimalDAO) {
    val allAnimals: Flow<List<Animal>> = animalDAO.getAllAnimal();
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(animal: Animal) {
        animalDAO.insert(animal)
    }
}