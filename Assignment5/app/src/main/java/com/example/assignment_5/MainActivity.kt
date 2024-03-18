package com.example.assignment_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val foodPreferences = Intent(this,FoodPreferences::class.java)
        val dietaryHabits = Intent(this,DietaryHabits::class.java)
        val prefBtn = findViewById<Button>(R.id.preferences)
        val dietBtn = findViewById<Button>(R.id.habits)
        prefBtn.setOnClickListener{
            startActivity(foodPreferences)
        }
        dietBtn.setOnClickListener {
            startActivity(dietaryHabits)
        }

    }
}