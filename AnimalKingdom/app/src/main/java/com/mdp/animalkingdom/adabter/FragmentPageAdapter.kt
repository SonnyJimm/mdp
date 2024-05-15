package com.mdp.animalkingdom.adabter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mdp.animalkingdom.animal.AnimalDetailFrament
import com.mdp.animalkingdom.species.SpeciesDetailFragment

class FragmentPageAdabter (fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount()=2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SpeciesDetailFragment()
            1 -> AnimalDetailFrament()
            else -> Fragment()
        }
    }
}