package com.example.sharedprefkt

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var firstname: EditText? = null
    var lastname: EditText? = null
    var age: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstname = findViewById(R.id.edit1)
        lastname = findViewById(R.id.edit2)
        age = findViewById(R.id.edit3)
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = getSharedPreferences("My shared preference", MODE_PRIVATE)
        val s1 = sharedPreferences.getString("first name", "")
        val s2 = sharedPreferences.getString("last name", "")
        val a = sharedPreferences.getInt("age", 0)
        firstname!!.setText(s1)
        lastname!!.setText(s2)
        age!!.setText(a.toString())
    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences = getSharedPreferences("My shared preference", MODE_PRIVATE)
        val myedit = sharedPreferences.edit()
        myedit.putString("first name", firstname!!.text.toString())
        myedit.putString("last name", lastname!!.text.toString())
        myedit.putInt("age", age!!.text.toString().toInt())
        myedit.apply()
    }
}