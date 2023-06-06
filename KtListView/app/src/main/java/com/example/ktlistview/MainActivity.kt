package com.example.ktlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView =  findViewById<ListView> (R.id.listView);
        val language:Array<String> = resources.getStringArray(R.array.tecnology_list)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,language)//Converts data item into view item So it can displayed on Ui components
        listView.adapter=arrayAdapter                                                                   //UI Component(Listview,Spinner,grindView,etc..):View items is Displayed in Listview,Etc..
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
        val seletedItem=adapterView.getItemAtPosition(position)as String
            val itemIdAtPos=adapterView.getItemAtPosition(position)
            Toast.makeText(applicationContext,"click item $seletedItem its position $itemIdAtPos",Toast.LENGTH_SHORT).show()
        }
    }
}