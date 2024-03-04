package com.example.assignment_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.assignment_3.Fragments.Login
import com.example.assignment_3.Fragments.Table
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tableFragment = Table()
        val loginFragmet = Login()
        makeCurrentFrtagment(tableFragment)
        val nav = findViewById<BottomNavigationView>(R.id.nav)
        nav.setOnNavigationItemSelectedListener { item->when(item.itemId){
                R.id.login -> makeCurrentFrtagment(loginFragmet)
                R.id.table -> makeCurrentFrtagment(tableFragment)
        }
            true
        }
    }
    private fun makeCurrentFrtagment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.frame_layout,fragment)
        commit()
    }
}