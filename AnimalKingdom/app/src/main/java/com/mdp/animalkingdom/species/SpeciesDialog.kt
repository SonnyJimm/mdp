package com.mdp.animalkingdom.species

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.mdp.animalkingdom.R
import com.mdp.animalkingdom.animal.Animal

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SpeciesDialog.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpeciesDialog(val speciesDetailFragment: SpeciesDetailFragment) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_species_dialog, null)
        val nameTxt: TextInputEditText = view.findViewById(R.id.species_name)
        val descriptionTxt: TextInputEditText = view.findViewById(R.id.species_description)
        builder.setView(view)
            .setTitle("Add Species")  // Optional: Set the dialog title
            .setPositiveButton("Add",null)
            .setNegativeButton("Cancel") { dialog, id ->
                // Handle the cancel button click
                dialog.cancel()
            }
        var dialog = builder.create();
        dialog.setOnShowListener {
            val addButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            addButton.setOnClickListener {
                val name = nameTxt.text.toString().trim()
                val description = descriptionTxt.text.toString().trim()

                if (name.isNotEmpty() && description.isNotEmpty() ) {
                    val species = Species(name = name, description = description)
                    speciesDetailFragment.onSubmit(species)
                    dialog.dismiss()
                } else {
                    Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return dialog;
    }
}