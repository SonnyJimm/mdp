package com.mdp.animalkingdom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mdp.animalkingdom.animal.Animal
import com.mdp.animalkingdom.animal.AnimalDAO
import com.mdp.animalkingdom.species.Species
import com.mdp.animalkingdom.species.SpeciesDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Animal::class,Species::class], version = 1, exportSchema = false)
public abstract class ProjectDatabase: RoomDatabase() {
    abstract fun animalDao(): AnimalDAO
    abstract fun speciesDao(): SpeciesDAO
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ProjectDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): ProjectDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProjectDatabase::class.java,
                    "kingdom"
                ).addCallback(DatabaseCallback(scope)).build()

                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
    private class DatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.animalDao(),database.speciesDao())

                }
            }
        }

        suspend fun populateDatabase(animalDAO: AnimalDAO,speciesDAO: SpeciesDAO) {
            // Delete all content here.
            animalDAO.deleteAll()

            // Add sample words.
            animalDAO.insert(Animal(name = "Lion", habitat = "Grasslands", diet = "Carnivore"))
            animalDAO.insert(Animal(name = "Elephant", habitat = "Forests and Savannahs", diet = "Herbivore"))
            animalDAO.insert(Animal(name = "Giraffe", habitat = "Savannahs", diet = "Herbivore"))
            animalDAO.insert(Animal(name = "Zebra", habitat = "Grasslands", diet = "Herbivore"))
            animalDAO.insert(Animal(name = "Tiger", habitat = "Forests", diet = "Carnivore"))

            speciesDAO.insert(Species(name = "Panthera leo", description = "The lion is a species in the family Felidae. It is known for its majestic appearance and fierce demeanor. Lions inhabit grasslands and savannas, and they are apex predators, primarily preying on large ungulates."))
            speciesDAO.insert(Species(name = "Loxodonta africana", description = "The African elephant is the largest living terrestrial animal. It is characterized by its long trunk, large ears, and tusks. African elephants inhabit forests and savannahs, and they are herbivores, feeding on a variety of vegetation."))
            speciesDAO.insert(Species(name = "Giraffa camelopardalis", description = "The giraffe is an African artiodactyl mammal, the tallest living terrestrial animal and the largest ruminant. Giraffes inhabit savannahs and woodlands, feeding primarily on leaves and shoots of trees."))
            speciesDAO.insert(Species(name = "Equus quagga", description = "The plains zebra is the most common subspecies of zebra, characterized by its distinctive black and white stripes. It inhabits grasslands and savannas, feeding on grass and other vegetation."))
            speciesDAO.insert(Species(name = "Panthera tigris", description = "The tiger is the largest extant cat species and a member of the genus Panthera. Tigers inhabit forests and grasslands, and they are apex predators, preying on various ungulates."))

        }
    }

}
