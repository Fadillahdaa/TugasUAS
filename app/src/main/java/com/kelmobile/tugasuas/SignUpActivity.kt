package com.kelmobile.tugasuas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val ivBack: ImageView = findViewById(R.id.ivBack)
        val etFullName: EditText = findViewById(R.id.etFullName)
        val etSignupEmail: EditText = findViewById(R.id.etSignupEmail)
        val etSignupPassword: EditText = findViewById(R.id.etSignupPassword)
        val etConfirmPassword: EditText = findViewById(R.id.etConfirmPassword)
        val cbTerms: CheckBox = findViewById(R.id.cbTerms)
        val btnSignup: Button = findViewById(R.id.btnSignup)
        val tvLoginLink: TextView = findViewById(R.id.tvLoginLink)
        val btnGoogleSignup: Button = findViewById(R.id.btnGoogleSignup)

        ivBack.setOnClickListener {
            finish() // Kembali ke activity sebelumnya
        }

        btnSignup.setOnClickListener {
            val fullName = etFullName.text.toString().trim()
            val email = etSignupEmail.text.toString().trim()
            val password = etSignupPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()
            val isTermsAccepted = cbTerms.isChecked

            if (fullName.isEmpty()) {
                etFullName.error = "Full Name is required"
                etFullName.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                etSignupEmail.error = "Email is required"
                etSignupEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etSignupPassword.error = "Password is required"
                etSignupPassword.requestFocus()
                return@setOnClickListener
            }

            if (confirmPassword.isEmpty()) {
                etConfirmPassword.error = "Confirm Password is required"
                etConfirmPassword.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                etConfirmPassword.error = "Passwords do not match"
                etConfirmPassword.requestFocus()
                return@setOnClickListener
            }

            if (!isTermsAccepted) {
                Toast.makeText(this, "You must accept the terms and conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // If all validations pass, proceed with sign-up logic
            Toast.makeText(this, "Sign-Up Successful", Toast.LENGTH_SHORT).show()
            // Example: Navigate to another activity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        tvLoginLink.setOnClickListener {
            // Navigate to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnGoogleSignup.setOnClickListener {
            // Implement Google sign-up logic here
            Toast.makeText(this, "Google Sign-Up clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
