package com.mdp.animalkingdom

import android.app.Application
import com.mdp.animalkingdom.animal.AnimalRepository
import com.mdp.animalkingdom.species.SpeciesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AnimalKingDomApplication :Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ProjectDatabase.getDatabase(this,applicationScope) }
    val animalRepository by lazy { AnimalRepository(database.animalDao()) }
    val speciesRepository by lazy { SpeciesRepository(database.speciesDao()) }

}