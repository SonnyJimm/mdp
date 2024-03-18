package com.example.assignment_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class DietaryHabits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dietary_habits)
        val backBtn:Button = findViewById(R.id.previous)
        backBtn.setOnClickListener {
            finish()
        }

        val vegetarian:RadioGroup = findViewById(R.id.vegetarian)
        val organic:RadioGroup = findViewById(R.id.organic)
        val dairy:RadioGroup = findViewById(R.id.dairy)
        val fastfood:RadioGroup = findViewById(R.id.fastfood)
        val allergies:RadioGroup = findViewById(R.id.allergies)
        val res:LinearLayout = findViewById(R.id.result)
        res.visibility = View.INVISIBLE
        val submit:Button = findViewById(R.id.submit)
        submit.setOnClickListener {
            fun validate(){
                if(vegetarian.checkedRadioButtonId == -1){
                    Toast.makeText(this,"Please choose your vegetarian or not",Toast.LENGTH_SHORT).show()
                    return
                }
                if(organic.checkedRadioButtonId == -1){
                    Toast.makeText(this,"Please choose your preference of organic food",Toast.LENGTH_SHORT).show()
                    return
                }
                if(dairy.checkedRadioButtonId == -1){
                    Toast.makeText(this,"Please answer if you can consume dairy food",Toast.LENGTH_SHORT).show()
                    return
                }
                if(fastfood.checkedRadioButtonId == -1){
                    Toast.makeText(this,"Please if choose if you eat fast food",Toast.LENGTH_SHORT).show()
                    return
                }
                if(allergies.checkedRadioButtonId == -1){
                    Toast.makeText(this,"Please if choose if have you an allergies",Toast.LENGTH_SHORT).show()
                    return
                }
                val resVeg:TextView = findViewById(R.id.resVeg)
                val resOrganic:TextView = findViewById(R.id.resOrganic)
                val reresDairysVeg:TextView = findViewById(R.id.resDairy)
                val resFast:TextView = findViewById(R.id.resFast)
                val resAllergy:TextView = findViewById(R.id.resAllergy)
                resVeg.setText(findViewById<RadioButton>(vegetarian.checkedRadioButtonId).text.toString())
                resOrganic.setText(findViewById<RadioButton>(organic.checkedRadioButtonId).text.toString())
                reresDairysVeg.setText(findViewById<RadioButton>(dairy.checkedRadioButtonId).text.toString())
                resFast.setText(findViewById<RadioButton>(fastfood.checkedRadioButtonId).text.toString())
                resAllergy.setText(findViewById<RadioButton>(allergies.checkedRadioButtonId).text.toString())
                Toast.makeText(this,"SUCCESS",Toast.LENGTH_SHORT).show()
                res.visibility = View.VISIBLE
            }
            validate()
        }
    }
}