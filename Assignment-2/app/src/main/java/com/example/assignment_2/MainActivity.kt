package com.example.assignment_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var guessWarning: TextView
    lateinit var guessInput: EditText
    lateinit var guessButton: Button
    lateinit var addWarning: TextView
    lateinit var addInput: EditText
    lateinit var addButton: Button
    var list = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        guessWarning = findViewById<TextView>(R.id.guessWarning);
        guessInput = findViewById<EditText>(R.id.guessInput);
        guessButton = findViewById<Button>(R.id.guessSubmit);
        addInput = findViewById<EditText>(R.id.addInput);
        addWarning = findViewById<TextView>(R.id.addWarning);
        addButton = findViewById<Button>(R.id.addSubmit);
        guessButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                guessOnSubmit()
            }
        })
        addButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                addOnSubmit()
            }
        })
    }
    fun guessOnSubmit(){
        if(list.size == 0){
            guessWarning.text = "Please add Element"
            return
        }
        var txt = guessInput.text
        if(txt.length == 0){
            guessWarning.text = "Please input valid input"
            return
        }
        val curr = (0 until list.size).random()
        var result = ""
        if (list.get(curr).equals(txt.toString().trim())){
            result = "Congratulations! You guessed it right it was "
        }else {
            result = "Sorry wrong guess the correct answer was "
        }
        guessWarning.text = result + list.get(curr)
        guessInput.setText("")
    }

    fun addOnSubmit(){
        val txt = addInput.text
        val value = txt.toString().trim()
        if (value.length == 0){
            addWarning.text = "Please Enter a valid name"
            return
        }
        for (element in list){
            if(element.equals(value)){
                addWarning.text = "Chemical " + value + " is already available"
                return
            }
        }
        addInput.setText("")
        list.add(value);
    }
}