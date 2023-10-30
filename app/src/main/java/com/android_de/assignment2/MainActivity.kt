package com.android_de.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var foodArr = mutableListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    private lateinit var decideBtn: Button
    private lateinit var foodTextView: TextView
    private lateinit var addFoodBtn: Button
    private lateinit var edtFoodText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideBtn = findViewById(R.id.decideBtn)
        decideBtn.setOnClickListener{
            showRandomFood()
        }

        addFoodBtn = findViewById(R.id.addFoodBtn)
        edtFoodText = findViewById(R.id.edtFoodText)
        addFoodBtn.setOnClickListener{
            val food = edtFoodText.text.toString()
            if(food.isNotEmpty()){
                foodArr.add(food)
                Toast.makeText(applicationContext, "$food is added!!!", Toast.LENGTH_SHORT).show()
                edtFoodText.text.clear()
            }else{
                Toast.makeText(applicationContext, "please enter food", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun showRandomFood(){
        if(foodArr.isNotEmpty()){
            val randomIndex = Random.nextInt(foodArr.size)
            val randomData = foodArr[randomIndex]
            foodTextView = findViewById(R.id.foodTextView)
            foodTextView.text = randomData
        }
    }
}