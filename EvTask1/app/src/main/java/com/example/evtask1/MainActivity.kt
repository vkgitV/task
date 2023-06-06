package com.example.evtask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.Collections.swap

class MainActivity : AppCompatActivity(),View.OnClickListener{
    private var a = arrayListOf<String>("One","Two","Three","Four","Five")

     var btn1:Button? =null
    var btn2:Button?=null
    var btn3:Button? =null
   var btn4:Button? =null
   var btn5:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        (btn1)?.setOnClickListener(this)
        (btn2)?.setOnClickListener(this)
        (btn3)?.setOnClickListener(this)
        (btn4)?.setOnClickListener(this)
        (btn5)?.setOnClickListener(this)

        btn1?.text = a.get(3)
        btn2?.text = a.get(4)
        btn3?.text = a.get(0)
        btn4?.text = a.get(2)
        btn5?.text = a.get(1)

    }

    override fun onClick(v: View?) {
    when (v?.id) {
            R.id.btn1 -> {
              swap()
            }
        R.id.btn2 -> {
              swap()
        }
        R.id.btn3 -> {
           swap()
        }
        R.id.btn4 -> {
           swap()
        }
        R.id.btn5 -> {
          swap()
        }
        }
    }

     fun swap() {
        when (a.indexOf(btn1?.text)) {
            0 -> btn1?.text = a[4]
            1 -> btn1?.text = a[0]
            2 -> btn1?.text = a[1]
            3 -> btn1?.text = a[2]
            4 -> btn1?.text = a[3]
        }
        when (a.indexOf(btn2?.text)) {
            0 -> btn2?.text = a[4]
            1 -> btn2?.text = a[0]
            2 -> btn2?.text = a[1]
            3 -> btn2?.text = a[2]
            4 -> btn2?.text = a[3]
        }
        when (a.indexOf(btn3?.text)) {
            0 -> btn3?.text = a[4]
            1 -> btn3?.text = a[0]
            2 -> btn3?.text = a[1]
            3 -> btn3?.text = a[2]
            4 -> btn3?.text = a[3]
        }
        when (a.indexOf(btn4?.text)) {
            0 -> btn4?.text = a[4]
            1 -> btn4?.text = a[0]
            2 -> btn4?.text = a[1]
            3 -> btn4?.text = a[2]
            4 -> btn4?.text = a[3]
        }
        when (a.indexOf(btn5?.text)) {
            0 -> btn5?.text = a[4]
            1 -> btn5?.text = a[0]
            2 -> btn5?.text = a[1]
            3 -> btn5?.text = a[2]
            4 -> btn5?.text = a[3]
        }
    }
}

