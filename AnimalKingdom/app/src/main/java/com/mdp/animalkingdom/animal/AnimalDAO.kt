package com.mdp.animalkingdom.animal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimalDAO {
    @Query("SELECT * FROM animal ORDER BY id")
    fun getAllAnimal(): Flow<List<Animal>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(animal: Animal)
    @Query("DELETE FROM animal")
    suspend fun deleteAll()
}