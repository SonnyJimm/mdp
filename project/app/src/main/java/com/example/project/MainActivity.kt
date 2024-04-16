package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pageAdabter = FragmentPageAdabter(this)
        val container = findViewById<ViewPager2>(R.id.container);
        container.adapter = pageAdabter;
        val layout = findViewById<TabLayout>(R.id.tabLayout);
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView);
        TabLayoutMediator(layout,container){ tab,position->
            when(position){
                0->{
                   tab.text="Sports"
                }
                1->{
                    tab.text="News"
                }
                2->{
                    tab.text="Athletes"
                }
                3->{
                    tab.text="Events"
                }
                4->{
                    tab.text="Historical Sports"
                }
                5->{
                    tab.text="About Me"
                }
            }
        }.attach()
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.botNavNews->{
                    layout.selectTab(layout.getTabAt(1))
                }
                R.id.botNavEvents->{
                    layout.selectTab(layout.getTabAt(3))
                }
                R.id.botNavArchive->{
                    layout.selectTab(layout.getTabAt(4))
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}