package com.kelmobile.tugasuas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        // Mengatur gambar profil
        val profileImage: ImageView = findViewById(R.id.profileImage)
        profileImage.setImageResource(R.drawable.orang)

        // Mengatur nama profil
        val profileName: TextView = findViewById(R.id.profileName)
        profileName.text = "Robert Johnson"

        // Mengatur tanggal bergabung
        val profileJoinDate: TextView = findViewById(R.id.profileJoinDate)
        profileJoinDate.text = "Joined: 20th April"

        // Tambahkan listener untuk setiap item menu jika diperlukan
        // Contoh:
        // val addHomeLayout: LinearLayout = findViewById(R.id.add_home_layout)
        // addHomeLayout.setOnClickListener {
        //     // Aksi yang ingin dilakukan ketika item Add Home diklik
        // }
    }
}
