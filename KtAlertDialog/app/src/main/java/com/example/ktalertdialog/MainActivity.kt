package com.example.ktalertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val builder=AlertDialog.Builder(this)    //set title for alert dialog
            builder.setTitle(R.string.title)              //set title for alert dialog
            builder.setMessage(R.string.message)    //set message for alert dialog

            builder.setPositiveButton("yes"){dialogInterface,which-> //performing positive action
                Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("no"){dialogInterface,which->//performing negative action
                Toast.makeText(applicationContext,"clicked no",Toast.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("Cancle"){dialoginterface,which->//performing cancel action
                Toast.makeText(applicationContext,"clicked cancle",Toast.LENGTH_SHORT).show()
            }
            val alertDialog:AlertDialog=builder.create()//Create AlretDialog
            alertDialog.setCancelable(false)//set other dialog properties
            alertDialog.show()
        }


    }
}