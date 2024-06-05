package com.kelmobile.tugasuas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val menuList = listOf(
            MenuItem("Large Menu", "Large Popcorn & Large Coca Cola", 30.0),
            MenuItem("Medium Menu", "Medium Popcorn & Medium Coca Cola", 20.0),
            MenuItem("Small Menu", "Small Popcorn & Small Coca Cola", 15.0),
            MenuItem("Advantageous Dual Menus", "Various combinations", 30.0)
        )

        val adapter = MenuAdaptor(menuList)
        recyclerView.adapter = adapter
    }
}
