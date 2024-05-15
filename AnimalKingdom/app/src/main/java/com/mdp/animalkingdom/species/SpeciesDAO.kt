package com.mdp.animalkingdom.species

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SpeciesDAO {
    @Query("SELECT * FROM species ORDER BY id")
    fun getAllSpecies(): Flow<List<Species>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(species: Species)
    @Query("DELETE FROM species")
    suspend fun deleteAll()
}