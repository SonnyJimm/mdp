package com.mdp.animalkingdom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mdp.animalkingdom.adabter.FragmentPageAdabter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pageAdabter = FragmentPageAdabter(this)
        val container = findViewById<ViewPager2>(R.id.container);
        container.adapter = pageAdabter;
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView);
        container.isUserInputEnabled = false
        bottomNav.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.botSpecies->container.setCurrentItem(0,true)
                    R.id.botAnimal->container.setCurrentItem(1,true)
                }

            true
        }

    }
}