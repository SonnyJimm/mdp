package com.example.assignment_5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController


class FoodPreferences : AppCompatActivity() {

    var favPos:Int = 0;
    var outPos:Int = 0;
    var vegetarianFood:Int = 0;
    var seaFood:Int = 0;
    var spicyFood:Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_preferences)
        val backBtn:Button = findViewById(R.id.previous)
        backBtn.setOnClickListener {
            finish()
        }
        val fav: Spinner = findViewById(R.id.fav)
        ArrayAdapter.createFromResource(this,R.array.food_fav,android.R.layout.simple_spinner_item).also {
            adapter->adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fav.adapter = adapter
        }
        fav.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                favPos = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                favPos = 0
            }
        }
        val out: Spinner = findViewById(R.id.out)
        ArrayAdapter.createFromResource(this,R.array.food_out,android.R.layout.simple_spinner_item).also {
                adapter->adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                out.adapter = adapter
        }
        out.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                outPos = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                outPos = 0
            }
        }
        val spicy: RadioGroup = findViewById(R.id.spicy)
        val vegetarian: RadioGroup = findViewById(R.id.vegetarian)
        val sea: RadioGroup = findViewById(R.id.sea)
        val submit: Button = findViewById(R.id.submit)
        val result: LinearLayout = findViewById(R.id.result)

        result.visibility  = View.INVISIBLE
        submit.setOnClickListener{
            fun validate(){
                if(favPos==0){
                    Toast.makeText(this,"Please choose fav cuisine",Toast.LENGTH_SHORT).show()
                    return
                }
                if (outPos==0){
                    Toast.makeText(this,"Please choose frequency of you eating interval",Toast.LENGTH_SHORT).show()
                    return
                }
                if (sea.checkedRadioButtonId==-1){
                    Toast.makeText(this,"Please choose whether you like spicy food",Toast.LENGTH_SHORT).show()
                    return
                }
                if (vegetarian.checkedRadioButtonId==-1){
                    Toast.makeText(this,"Please choose whether you are vegetarian or not",Toast.LENGTH_SHORT).show()
                    return
                }
                if (spicy.checkedRadioButtonId==-1){
                    Toast.makeText(this,"Please choose whether you like sea food or not",Toast.LENGTH_SHORT).show()
                    return
                }
                result.visibility  = View.VISIBLE
                Toast.makeText(this,"SUCCESS",Toast.LENGTH_SHORT).show()
                val resCuisine: TextView = findViewById(R.id.resCuisine)
                resCuisine.setText(fav.selectedItem.toString());
                val resOut: TextView = findViewById(R.id.resOut)
                resOut.setText(out.selectedItem.toString());
                val resSpicy: TextView = findViewById(R.id.resSpicy)
                resSpicy.setText(findViewById<RadioButton>(spicy.checkedRadioButtonId).text.toString())
                val resVeg: TextView = findViewById(R.id.resVeg)
                resVeg.setText(findViewById<RadioButton>(vegetarian.checkedRadioButtonId).text.toString())
                val resSea: TextView = findViewById(R.id.resSea)
                resSea.setText(findViewById<RadioButton>(sea.checkedRadioButtonId).text.toString())
            }
            validate()
        }
    }

}