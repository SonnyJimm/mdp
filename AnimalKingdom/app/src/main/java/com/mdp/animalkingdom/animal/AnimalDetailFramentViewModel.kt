package com.mdp.animalkingdom.animal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AnimalDetailFramentViewModel(private val repository: AnimalRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    val allAnimal = repository.allAnimals.asLiveData()

    fun insert(animal: Animal) = viewModelScope.launch {
        repository.insert(animal)
    }
}
class AnimalViewModelFactory(private val repository: AnimalRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimalDetailFramentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnimalDetailFramentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}