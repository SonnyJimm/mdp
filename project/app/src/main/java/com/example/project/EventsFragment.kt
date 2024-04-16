package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EventsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val holder = inflater.inflate(R.layout.fragment_events, container, false)
        val recyclerView = holder.findViewById<RecyclerView>(R.id.eventList)
        recyclerView.layoutManager = LinearLayoutManager(holder.context,
            LinearLayoutManager.VERTICAL,false)
        var list = ArrayList<EventModel>()
        val adapter = EventAdabpter(list,holder.context)
        recyclerView.adapter = adapter
        list.add(EventModel("Men's Final Four","05/04/2024","Next spring, 68 collegiate teams comprised of the country’s best and brightest amateur athletes in the game of basketball will compete for the title of National Champions. In 2024, the biggest games of the season will play out in Phoenix, Arizona. The two national semi-final matches will take place on April 6, 2024 and the national championship final will follow on April 8th"))
        list.add(EventModel("Miami Grand Prix","05/02/2024","Since its spectacular debut in 2022, the Miami Grand Prix has quickly become one of the hottest tickets in the sporting world. The next Miami Grand Prix will take place on May 5, 2024, at the Miami International Autodrome. The race encapsulates everything we know and love about Miami: plenty of glitz and glamour, sophistication, excitement, and celebrity presence."))
        list.add(EventModel("Indianapolis 500 ","05/27/2024","The Indy 500 is IndyCar’s most prestigious event and is held annually at the iconic Indianapolis Motor Speedway. The race plays out over 500 miles (200 laps) and is traditionally held over Memorial Day Weekend. The next Indy 500 is scheduled for May 26, 2024 and will be the 108th running of this thrilling event. This beloved race showcases the top level of American Championship IndyCar racing. It is considered part of the Triple Crown of Motorsport, one of the three most prestigious motorsport events in the world (the 24 Hours of Le Mans and the Monaco Grand Prix are the other two). The inaugural race was held in 1911 and was won by Ray Harroun."))
        list.add(EventModel("French Open","05/26/2024","Be there as tennis’ brightest stars converge in Paris to battle it out at the world’s greatest clay court championships. The thrilling tennis action combined with the universally loved destination of Paris creates an incredible sports travel experience."))

        adapter.notifyDataSetChanged()
        return holder
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EventsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EventsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}