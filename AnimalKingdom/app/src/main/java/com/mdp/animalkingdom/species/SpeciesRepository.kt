package com.mdp.animalkingdom.species

import androidx.annotation.WorkerThread
import com.mdp.animalkingdom.animal.Animal
import kotlinx.coroutines.flow.Flow

class SpeciesRepository (private val speciesDAO: SpeciesDAO){

    val allSpecies: Flow<List<Species>> = speciesDAO.getAllSpecies();
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(species: Species) {
        speciesDAO.insert(species)
    }
}