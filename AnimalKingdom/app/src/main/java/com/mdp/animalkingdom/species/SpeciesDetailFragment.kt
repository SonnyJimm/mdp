package com.mdp.animalkingdom.species

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mdp.animalkingdom.AnimalKingDomApplication
import com.mdp.animalkingdom.R
import com.mdp.animalkingdom.adabter.SpeciesListAdabpter
import com.mdp.animalkingdom.animal.AnimalDetailFramentViewModel
import com.mdp.animalkingdom.animal.AnimalDialog

class SpeciesDetailFragment : Fragment() {

    companion object {
        fun newInstance() = SpeciesDetailFragment()
    }

    private lateinit var viewModel: SpeciesDetailViewModel
    private lateinit var view: View;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_species_detail, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.speciesRecycler)
        var adapter = SpeciesListAdabpter()
        recyclerView.adapter = adapter
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(view.context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = layoutManager

        val application = requireActivity().application as AnimalKingDomApplication
        val repository = application.speciesRepository
        val viewModelFactory = SpeciesViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(SpeciesDetailViewModel::class.java)
        val addSpeciesBtn = view.findViewById<FloatingActionButton>(R.id.speciesAdd)
        addSpeciesBtn.setOnClickListener(){
            SpeciesDialog(this).show(this.parentFragmentManager,"Species add")
        }
        viewModel.allSpecies.observe(viewLifecycleOwner, Observer { species-> species.let { adapter.submitList(species) } })

        return view
    }

    fun onSubmit(species: Species){
        viewModel.insert(species)
        Toast.makeText(view.context,"Successfully Added", Toast.LENGTH_SHORT).show();
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpeciesDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}