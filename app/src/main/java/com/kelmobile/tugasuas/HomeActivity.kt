package com.kelmobile.tugasuas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewPager = findViewById(R.id.view_pager)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set up ViewPager with an adapter
        val imageList = listOf(
            R.drawable.img, // Ganti dengan resource gambar Anda
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9
        )

        val adapter = ImagePagerAdaptor(imageList) { position ->
            // Handle click event
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("image_res", imageList[position as Int])
            startActivity(intent)
        }
        viewPager.adapter = adapter

        // Set up bottom navigation
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_explore -> {
                    // Handle explore navigation
                    true
                }
                R.id.nav_wishlist -> {
                    // Handle wishlist navigation
                    true
                }
                R.id.nav_inbox -> {
                    // Handle inbox navigation
                    true
                }
                R.id.nav_profile -> {
                    // Handle profile navigation
                    true
                }
                else -> false
            }
        }
    }
}
