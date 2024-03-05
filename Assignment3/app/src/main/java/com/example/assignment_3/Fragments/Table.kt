package com.example.assignment_3.Fragments

import com.example.assignment_3.R
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Table.newInstance] factory method to
 * create an instance of this fragment.
 */
class Table : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val frg = inflater.inflate(R.layout.fragment_table, container, false)
        val resource = frg.findViewById<EditText>(R.id.resource)
        val location = frg.findViewById<EditText>(R.id.location)
        val type = frg.findViewById<EditText>(R.id.type)
        val add = frg.findViewById<Button>(R.id.add)
        val table = frg.findViewById<TableLayout>(R.id.table)
        add.setOnClickListener{
            val rName = resource?.text.toString()
            val rLocation = location?.text.toString()
            val rType = type?.text.toString()
            if(rName.length <= 0 || !"^[A-Z][a-zA-Z ]*\$".toRegex().matches(rName)){
                Toast.makeText(context,"Not valid resource name",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(rLocation.length <= 0 || !"^[A-Z][a-zA-Z ]*\$".toRegex().matches(rLocation)){
                Toast.makeText(context,"Not valid Location",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(rType.length <= 0 || !"^[A-Z][a-zA-Z ]*\$".toRegex().matches(rType)){
                Toast.makeText(context,"Not valid Type",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val row = TableRow(context);
            val txt1 = createText(context,rName);
            val txt2 =  createText(context,rLocation);
            val txt3 =  createText(context,rType);
            row.addView(txt1)
            row.addView(txt2)
            row.addView(txt3)
            table.addView(row)
            resource?.setText("")
            location?.setText("")
            type?.setText("")
            Toast.makeText(context,"Added successfully",Toast.LENGTH_SHORT).show()
        }
        return frg
    }
    fun createText(context:Context?,data:String):TextView{
        val txt = TextView(context);
        txt.text = data
        txt.background = context?.let { it1 -> ContextCompat.getDrawable(it1,R.drawable.border) }
        txt.setPadding(TypedValue.COMPLEX_UNIT_PT*5)
        return txt
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Table.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Table().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}