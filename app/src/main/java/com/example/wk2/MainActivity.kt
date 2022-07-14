package com.example.wk2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.EditText
import android.widget.Button
import kotlin.math.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //linking UI to program

        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate: Button = findViewById(R.id.buttonReset)
        val buttonReset: Button = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener{
            //get input from user cannot empty
            if(editTextWeight.text.isEmpty()){
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener //end program here and return back to page
            }
            val weight = editTextWeight.text.toString().toFloat()

            //if empty do something else-
            val height =editTextHeight.text.toString().toFloatOrNull()
            if(height==null){
                editTextHeight.setError(getString(R.string.value_required))
                return@setOnClickListener

            }
            val bmi = weight/(height /100).pow(2)

            if(bmi< 18.5){//Underwiehgt =<18.5
                imageViewBMI.setImageResource(R.drawable.under)
                textViewBMI.text = String.format("%s %s (%.2f)" , getString(R.string.bmi), getString(R.string.underweight),bmi)
            }
            else if(bmi >25){//overwieght >25
                imageViewBMI.setImageResource(R.drawable.over)
                textViewBMI.text = String.format("%s %s (%.2f)" , getString(R.string.bmi), getString(R.string.underweight),bmi)

            }else{
                imageViewBMI.setImageResource(R.drawable.normal)
                textViewBMI.text = String.format("%s %s (%.2f)" , getString(R.string.bmi), getString(R.string.underweight),bmi)
            }

        }
     //   buttonReset.setOnClickListener{
      //      empty
       //     return@setOnClickListener
        }
}
