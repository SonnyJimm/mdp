package com.bachir.sportsnewsandinformationapp.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.project.AthletesFragment
import com.example.project.AthletesModel
import com.example.project.R
import com.google.android.material.textfield.TextInputEditText

class AthleteDialog(val athletesFragment: AthletesFragment) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_athlete, null)

        val name = view.findViewById<TextInputEditText>(R.id.tiet_name)
        val competingSport = view.findViewById<TextInputEditText>(R.id.tiet_competing_sport)
        val country = view.findViewById<TextInputEditText>(R.id.tiet_country)
        val personal = view.findViewById<TextInputEditText>(R.id.tiet_personal)
        val medals = view.findViewById<TextInputEditText>(R.id.tiet_medals)
        val facts = view.findViewById<TextInputEditText>(R.id.tiet_facts)

        builder.setView(view)
            .setPositiveButton("OK") { dialog, _ ->
                // Handle positive button click
                val athlete = AthletesModel(name.text.toString(), competingSport.text.toString(),
                    country.text.toString(), personal.text.toString(),
                    medals.text.toString(), facts.text.toString())



                athletesFragment.addAthlete(athlete)

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click
                dialog.dismiss()
            }
        return builder.create()
    }
}