package com.example.project

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.dialog.SportDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SportsFragment : Fragment() {

    companion object {
        fun newInstance() = SportsFragment()
    }
    private lateinit var listAdabter :SportCategoryAdabter
    private lateinit var viewModel: SportsViewModel
    private lateinit var list : ArrayList<SportCategoryModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var holder = inflater.inflate(R.layout.fragment_sports, container, false)
        var recyclerView = holder.findViewById<RecyclerView>(R.id.categories);
        list = ArrayList<SportCategoryModel>()
        val layoutManager = GridLayoutManager(holder.context, 2);
        recyclerView.layoutManager = layoutManager
        listAdabter = SportCategoryAdabter(list,holder.context)
        recyclerView.adapter = listAdabter
        list.add(SportCategoryModel("Measure","Car racing","Auto racing is a motorsport involving the racing of automobiles for competition. In North America, the term is commonly used to describe all forms of automobile sport including non-racing disciplines. Auto racing has existed since the invention of the automobile"))
        list.add(SportCategoryModel("Precision","Archery","\n" +
                " ∙ Choose area\n" +
                "Archery is the sport, practice, or skill of using a bow to shoot arrows. The word comes from the Latin arcus, meaning bow. Historically, archery has been used for hunting and combat. In modern times, it is mainly a competitive sport and recreational activity."))
        list.add(SportCategoryModel("Spectacle","gymnastics","Gymnastics is a type of sport that includes physical exercises requiring balance, strength, flexibility, agility, coordination, artistry and endurance. The movements involved in gymnastics contribute to the development of the arms, legs, shoulders, back, chest, and abdominal muscle groups"))
        list.add(SportCategoryModel("Combat","Fencing","Fencing is a combat sport that features sword fighting. The three disciplines of modern fencing are the foil, the épée, and the sabre; each discipline uses a different kind of blade, which shares the same name, and employs its own rules. Most competitive fencers specialise in one discipline."))
        list.add(SportCategoryModel("Play","Volleyball","This exciting sport creates a dynamic and thrilling game that appeals to players and spectators alike. Whether you are a casual fan or an avid player, here is everything you need to know about volleyball.\n" +
                "\n" +
                "First and foremost, it is important to understand what volleyball actually is. At its core, this sport involves two teams facing off against each other on a court divided into halves by a net. The object of the game is to use your hands or arms to hit a ball over the net so that it lands inside your opponent's half of the court. You score a point every time you do this, and the first team to reach 25 points wins the game.\n" +
                "\n" +
                "Of course, there is more to volleyball than hitting a ball over the net. To be successful at this sport, you need to have excellent hand-eye coordination and strong reflexes. Additionally, it helps to know how to serve, receive, pass, block, and set the ball.\n" +
                "\n" +
                "So, whether you play on a professional team, compete in local leagues, or just for fun, there are always opportunities to get out on the court and show off your skills.\n" +
                "\n"))

        listAdabter.notifyDataSetChanged()
        val btn = holder.findViewById<FloatingActionButton>(R.id.addSport)
        btn.setOnClickListener{
            SportDialog(this).show(parentFragmentManager,"Sport dialog")
        }
        return holder
    }
    fun addSport(sportCategoryModel: SportCategoryModel){
        list.add(sportCategoryModel)
        listAdabter.notifyItemChanged(list.size-1)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SportsViewModel::class.java)
    }

}