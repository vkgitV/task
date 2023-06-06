package com.example.ktsharedpref

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var name: EditText
    private lateinit var password: EditText
    private lateinit var button: Button
    private lateinit var checkBox: CheckBox
    private lateinit var strName: String
    private lateinit var strPassword: String
    private lateinit var strCheckBox: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.etName)
        password = findViewById(R.id.etPassword)
        button = findViewById(R.id.btnLogin)
        checkBox = findViewById(R.id.checkbox)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        editor = sharedPreferences.edit()

        checkSharedPreference()
        button.setOnClickListener {
            if (checkBox.isChecked) {
                editor.putString(getString(R.string.checkBox), "true")
                editor.apply()
                strName = name.text.toString()
                editor.putString(getString(R.string.name), strName)
                editor.commit()
                strPassword = password.text.toString()
                editor.putString(getString(R.string.password), strPassword)
                editor.commit()
            } else {
                editor.putString(getString(R.string.checkBox), "False")
                editor.commit()
                editor.putString(getString(R.string.name), "")
                editor.commit()
                editor.putString(getString(R.string.password), "")
editor.commit()
            }
        }
    }
    private fun checkSharedPreference() {
        strCheckBox=sharedPreferences.getString(getString(R.string.checkBox),"false").toString()
        strName = sharedPreferences.getString(getString(R.string.name), "").toString()
        strPassword = sharedPreferences.getString(getString(R.string.password), "").toString()
        name.setText(strName)
        password.setText(strPassword)
        checkBox.isChecked = strCheckBox == "True"
    }
}