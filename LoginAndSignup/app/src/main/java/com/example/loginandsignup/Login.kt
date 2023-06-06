package com.example.loginandsignup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Login : AppCompatActivity() {
    var LoginText: EditText? = null
    var PasswordText: EditText? = null
    var btnlogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoginText = findViewById<View>(R.id.login) as EditText
        PasswordText = findViewById<View>(R.id.Password) as EditText
        btnlogin = findViewById<View>(R.id.buttonlogin) as Button
        btnlogin!!.setOnClickListener {
            val username = LoginText!!.text.toString()
            val Password = PasswordText!!.text.toString()
            if (username == "email" && Password == "12345") {
                Toast.makeText(this@Login, "welcome", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, NewActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@Login, "invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}