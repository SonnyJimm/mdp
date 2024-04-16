package com.example.project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.dialog.AthleteDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AthletesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AthletesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var list :ArrayList<AthletesModel>
    private lateinit var listAdabter: AthleteAdabter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val holder = inflater.inflate(R.layout.fragment_athletes, container, false)
        var recyclerView = holder.findViewById<RecyclerView>(R.id.athleteList)
        recyclerView.layoutManager = LinearLayoutManager(holder.context,LinearLayoutManager.VERTICAL,false)
        list  = arrayListOf(
            AthletesModel(
                "Usain Bolt",
                "Track and Field",
                "Jamaica",
                "100m Sprint",
                "8 Olympic Golds, 11 World Championship Golds",
                "Bolt is the fastest man in history, setting the world record of 9.58 seconds in the 100m."
            ),
            AthletesModel(
                "Serena Williams",
                "Tennis",
                "USA",
                "Grand Slam Titles",
                "23 Grand Slam Titles",
                "Williams is one of the greatest tennis players of all time, dominating the sport for over two decades."
            ),
            AthletesModel(
                "Michael Phelps",
                "Swimming",
                "USA",
                "Olympic Gold Medals",
                "23 Olympic Golds, 28 Olympic Medals",
                "Phelps holds the record for the most Olympic gold medals in history, showcasing unparalleled dominance in the pool."
            ),
            AthletesModel(
                "Simone Biles",
                "Gymnastics",
                "USA",
                "All-Around Gymnastics",
                "4 Olympic Golds, 19 World Championship Golds",
                "Biles is considered one of the greatest gymnasts of all time, known for her gravity-defying skills and unmatched consistency."
            ),
            AthletesModel(
                "Cristiano Ronaldo",
                "Soccer",
                "Portugal",
                "UEFA Champions League Titles",
                "5 UEFA Champions League Titles",
                "Ronaldo is one of the most prolific goal scorers in soccer history, known for his athleticism and versatility."
            ),
            AthletesModel(
                "Roger Federer",
                "Tennis",
                "Switzerland",
                "Grand Slam Titles",
                "20 Grand Slam Titles",
                "Federer is widely regarded as one of the greatest tennis players of all time, known for his elegance and skill."
            ),
            AthletesModel(
                "Katie Ledecky",
                "Swimming",
                "USA",
                "Olympic Gold Medals",
                "7 Olympic Golds, 15 World Championship Golds",
                "Ledecky is one of the most dominant swimmers in history, specializing in freestyle events."
            ),
            AthletesModel(
                "LeBron James",
                "Basketball",
                "USA",
                "NBA Championships",
                "4 NBA Championships",
                "James is a basketball icon, known for his versatility, athleticism, and leadership on and off the court."
            ),
            AthletesModel(
                "Lionel Messi",
                "Soccer",
                "Argentina",
                "Ballon d'Or Awards",
                "7 Ballon d'Or Awards",
                "Messi is widely regarded as one of the greatest soccer players of all time, known for his dribbling and playmaking abilities."
            ),
            AthletesModel(
                "Sachin Tendulkar",
                "Cricket",
                "India",
                "Cricket Records",
                "Various Cricket Records",
                "Tendulkar is a cricket legend, holding numerous batting records and revered as the 'God of Cricket' in India."
            )
        )
        listAdabter = AthleteAdabter(list,holder.context)
        recyclerView.adapter = listAdabter
        val btn = holder.findViewById<FloatingActionButton>(R.id.athleteAdd)
        btn.setOnClickListener{
            AthleteDialog(this).show(parentFragmentManager,"Athlete Dialog")
        }
        return holder
    }
    fun addAthlete(athlete:AthletesModel){
        list.add(athlete)
        listAdabter.notifyItemChanged(list.size-1)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AthletesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AthletesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}