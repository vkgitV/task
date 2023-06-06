package com.example.dicerollere

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {// Appcompt is subclass of Activity. used to app available to largest number of devices and users possible
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//R class includes all the apps assets including content of the res
   val rollButton:Button=findViewById(R.id.button)
    rollButton.setOnClickListener{rollDice()}

    }

    private fun rollDice() {
        Toast.makeText(this,"Dice Rolled",Toast.LENGTH_SHORT).show()

        val randomInt=(1..40).random() // method to get a random number between 1 and 6
        val resultText:TextView=findViewById(R.id.txtView)

        resultText.text=randomInt.toString()


    }
}