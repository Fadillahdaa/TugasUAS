package com.kelmobile.tugasuas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val moviePoster = findViewById<ImageView>(R.id.movie_poster)
        val movieTitle = findViewById<TextView>(R.id.movie_title)
        val movieGenre = findViewById<TextView>(R.id.movie_genre)
        val movieRating = findViewById<TextView>(R.id.movie_rating)
        val movieDescription = findViewById<TextView>(R.id.movie_description)
        val btnBookTickets = findViewById<Button>(R.id.btn_book_tickets)

        // Get the data passed from the previous activity
        val imageRes = intent.getIntExtra("image_res", R.drawable.img)
        moviePoster.setImageResource(imageRes)

        // Set the rest of the details (these can be dynamic or hardcoded as shown)
        movieTitle.text = "Dilan 1990"
        movieGenre.text = "Horror | Action"
        movieRating.text = "⭐ 4.7"
        movieDescription.text = "Film Dilan 1990 memulai kisahnya dengan kepindahan Milea (Vanesha Prescilla) dan keluarganya ke Bandung. Ini pun menjadi petualangan dan babak baru bagi Milea. Peristiwa ini juga yang kemudian mempertemukan Milea dengan Dilan (Iqbaal Ramadhan), murid yang dikenal sebagai salah satu anggota geng motor di kota itu."

        // Set up button click listener
        btnBookTickets.setOnClickListener {
            val intent = Intent(this, TicketBookingActivity::class.java)
            startActivity(intent)
        }
    }
}
