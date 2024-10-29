package com.example.cafereservation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class  LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inisialisasi Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Inisialisasi tampilan
        usernameEditText = findViewById(R.id.et_username)
        phoneNumberEditText = findViewById(R.id.et_phone_number)
        loginButton = findViewById(R.id.btn_login)

        // Atur listener untuk tombol login
        loginButton.setOnClickListener { handleLogin() }
    }

    private fun handleLogin() {
        val username = usernameEditText.text.toString().trim()
        val phoneNumber = phoneNumberEditText.text.toString().trim()

        // Validasi input
        if (username.isEmpty()) {
            usernameEditText.error = "Username is required"
            return
        }

        if (phoneNumber.isEmpty()) {
            phoneNumberEditText.error = "Phone number is required"
            return
        }

        if (!phoneNumber.matches("^\\d{10,15}\$".toRegex())) {
            phoneNumberEditText.error = "Invalid phone number"
            return
        }

        // Lakukan login anonymous Firebase
        performAnonymousLogin()
    }

    private fun performAnonymousLogin() {
        auth.signInAnonymously().addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Login sukses, pindah ke MainActivity
                navigateToMainActivity()
            } else {
                // Jika gagal
                Toast.makeText(this, "Login failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Fungsi untuk pindah ke MainActivity
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Menutup LoginActivity setelah berpindah ke MainActivity
    }
}
