package com.kelmobile.tugasuas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvError: TextView
    private lateinit var cbKeepSignedIn: CheckBox
    private lateinit var btnLogin: Button
    private lateinit var tvSignUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tvError = findViewById(R.id.tvError)
        cbKeepSignedIn = findViewById(R.id.cbKeepSignedIn)
        btnLogin = findViewById(R.id.btnLogin)
        tvSignUp = findViewById(R.id.tvSignUp)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            if (email == "Rhehbhek@gmail.com" && password == "password") {
                // Logic for successful login
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                tvError.visibility = TextView.VISIBLE
            }
        }

        tvSignUp.setOnClickListener {
            // Navigate to Sign Up Activity
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                tvError.visibility = TextView.GONE
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
