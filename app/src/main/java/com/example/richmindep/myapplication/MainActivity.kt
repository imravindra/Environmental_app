package com.example.richmindep.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<ListView>(R.id.listView)
        val array: Array<out String>? = list.resources.getStringArray(R.array.sollist)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        list.setOnItemClickListener { _, _, i, _ ->
            if(array!![i] == "Car Pooling") {
                val intent = Intent(MainActivity@this, Pooling::class.java)
                startActivity(intent)
            }else {
                val plasticIntent = Intent(MainActivity@this, Plastic::class.java)
                startActivity(plasticIntent)
            }
        }
        list.adapter = adapter

        
    }
}
