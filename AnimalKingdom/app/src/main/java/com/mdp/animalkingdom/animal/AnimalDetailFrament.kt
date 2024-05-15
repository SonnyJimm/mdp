package com.mdp.animalkingdom.animal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mdp.animalkingdom.AnimalKingDomApplication
import com.mdp.animalkingdom.R
import com.mdp.animalkingdom.adabter.AnimalListAdabpter

class AnimalDetailFrament : Fragment() {

    companion object {
        fun newInstance() = AnimalDetailFrament()
    }

    private lateinit var viewModel: AnimalDetailFramentViewModel
    private lateinit var view: View;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view=  inflater.inflate(R.layout.fragment_animal_detail_frament, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.animalRecycler)
        val adapter = AnimalListAdabpter()
        recyclerView.adapter = adapter
        val layoutManager =GridLayoutManager(view.context,
            2)
        recyclerView.layoutManager = layoutManager

        val application = requireActivity().application as AnimalKingDomApplication
        val repository = application.animalRepository
        val viewModelFactory = AnimalViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AnimalDetailFramentViewModel::class.java)
        viewModel.allAnimal.observe(viewLifecycleOwner, Observer { animals ->
            animals.let {
                adapter.submitList(animals)
            }
        })
        var btn:FloatingActionButton = view.findViewById(R.id.animalAdd)
        btn.setOnClickListener {
            AnimalDialog(this).show(this.parentFragmentManager,"animal add")
        }

        return view
    }
    fun onSubmit(animal: Animal){
        viewModel.insert(animal);
        Toast.makeText(view.context,"Successfully Added",Toast.LENGTH_SHORT).show();

    }
}