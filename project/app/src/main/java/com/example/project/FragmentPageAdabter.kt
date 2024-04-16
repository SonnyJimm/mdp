package com.example.project

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdabter (fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount()=6

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SportsFragment()
            1 -> NewsFragment()
            2 -> AthletesFragment()
            3 -> EventsFragment()
            4 -> HistoricalFragment()
            5 -> AboutFragment()
            else -> Fragment()
        }
    }
}