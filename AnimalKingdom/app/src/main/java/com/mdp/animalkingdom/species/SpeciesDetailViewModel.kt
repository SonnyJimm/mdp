package com.mdp.animalkingdom.species

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mdp.animalkingdom.animal.Animal
import com.mdp.animalkingdom.animal.AnimalDetailFramentViewModel
import com.mdp.animalkingdom.animal.AnimalRepository
import kotlinx.coroutines.launch

class SpeciesDetailViewModel(private val repository: SpeciesRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    val allSpecies = repository.allSpecies.asLiveData()

    fun insert(species: Species) = viewModelScope.launch {
        repository.insert(species)
    }
}

class SpeciesViewModelFactory(private val repository: SpeciesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SpeciesDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SpeciesDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}