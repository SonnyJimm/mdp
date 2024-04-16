package com.bachir.sportsnewsandinformationapp.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.project.HistoricalFragment
import com.example.project.HistoricalModel
import com.example.project.R

import com.google.android.material.textfield.TextInputEditText
import java.time.format.DateTimeFormatter
import java.util.Calendar

class ArchiveDialog(val historyFragment:HistoricalFragment) : DialogFragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_event, null)

        val name = view.findViewById<TextInputEditText>(R.id.tiet_name)
        val dateEditText = view.findViewById<TextInputEditText>(R.id.tiet_date)
        val date = view.findViewById<View>(R.id.v_date)
        val description = view.findViewById<TextInputEditText>(R.id.tiet_description)

        var dateSelected = Calendar.getInstance().time
        date.setOnClickListener(View.OnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(requireContext(),
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    // Display the selected date
                    val selectedDateStr = "$dayOfMonth/${monthOfYear + 1}/$year"
                    dateEditText.setText(selectedDateStr)

                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(year, monthOfYear, dayOfMonth)
                    dateSelected = selectedDate.time
                }, year, month, day)

            datePickerDialog.show()
        })

        builder.setView(view)
            .setPositiveButton("OK") { dialog, _ ->
                // Handle positive button click

                val archive = HistoricalModel(name.text.toString(), ""+dateSelected.day+"/"+dateSelected.month+"/"+dateSelected.year, description.text.toString())
                historyFragment.addHistory(archive)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click
                dialog.dismiss()
            }
        return builder.create()
    }
}