package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.dialog.ArchiveDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HistoricalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoricalFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var list :ArrayList<HistoricalModel>
    private lateinit var adapter:HistoryAdabpter
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
        val holder = inflater.inflate(R.layout.fragment_historical, container, false)
        val recyclerView = holder.findViewById<RecyclerView>(R.id.historicalList)
        list = arrayListOf (
            HistoricalModel("First Super Bowl", "01/15/1967", "The Green Bay Packers triumphed over the Kansas City Chiefs, marking the birth of a legendary sports tradition."),
            HistoricalModel("Miracle on Ice", "02/22/1980", "Team USA's unexpected victory against the dominant Soviet Union hockey team captivated the world during the Winter Olympics."),
            HistoricalModel("Jesse Owens at the 1936 Olympics", "08/09/1936", "Jesse Owens' historic performance shattered racial barriers and showcased athletic excellence amidst Nazi Germany's propaganda."),
            HistoricalModel("Muhammad Ali vs. Joe Frazier III", "10/01/1975", "The 'Thrilla in Manila' concluded with Ali's victory in an epic boxing battle, solidifying his status as 'The Greatest.'"),
            HistoricalModel("Boston Red Sox Break the Curse", "10/27/2004", "The Red Sox's long-awaited World Series win ended the 'Curse of the Bambino,' igniting jubilation among fans after an 86-year drought."),
            HistoricalModel("Roger Bannister's Four-Minute Mile", "05/06/1954", "Bannister's historic run epitomized human achievement, inspiring generations and redefining the limits of athletic performance."),
            HistoricalModel("Michael Phelps' Eight Gold Medals", "08/17/2008", "Phelps' unprecedented feat in the pool showcased unmatched dominance and cemented his legacy as the most decorated Olympian of all time."),
            HistoricalModel("USA Women's Soccer Team Wins World Cup", "07/10/1999", "Branded as soccer pioneers, the US Women's Team's victory sparked a global movement for gender equality in sports."),
            HistoricalModel("Babe Ruth's Called Shot", "10/01/1932", "Ruth's mythical 'called shot' home run in the World Series against the Cubs remains a legendary moment in baseball folklore."),
            HistoricalModel("The Rumble in the Jungle", "10/30/1974", "Ali's strategic triumph over Foreman in Zaire exemplified resilience and tactical brilliance in the face of overwhelming odds.")
        )
        adapter =HistoryAdabpter(list,holder.context)
        recyclerView.adapter =adapter
        recyclerView.layoutManager = LinearLayoutManager(holder.context,LinearLayoutManager.VERTICAL,false)
        val addArchive = holder.findViewById<FloatingActionButton>(R.id.addHistorical)
        addArchive.setOnClickListener{
            ArchiveDialog(this).show(parentFragmentManager,"archive dialog")
        }
        return holder
    }
    fun addHistory(model: HistoricalModel){
        list.add(model)
        adapter.notifyItemChanged(list.size-1)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HistoricalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistoricalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}