package com.kelmobile.tugasuas

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {

    private lateinit var searchBar: EditText
    private lateinit var searchResults: RecyclerView
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serch)

        searchBar = findViewById(R.id.search_bar)
        searchResults = findViewById(R.id.search_results)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        searchResults.layoutManager = LinearLayoutManager(this)
        // Initialize the adapter with your data
        // searchResults.adapter = YourAdapter(data)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_explore -> {
                    // Handle explore navigation
                    Toast.makeText(this, "Explore selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_wishlist -> {
                    // Handle wishlist navigation
                    Toast.makeText(this, "Wishlist selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_inbox -> {
                    // Handle inbox navigation
                    Toast.makeText(this, "Inbox selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_profile -> {
                    // Handle profile navigation
                    Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
