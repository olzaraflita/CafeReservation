package com.example.cafereservation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi BottomNavigationView
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Setup listener untuk navigasi
        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_cafes -> {
                    loadFragment(CafeListFragment())
                    true
                }
                R.id.nav_reservations -> {
                    loadFragment(ReservationsFragment())
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        // Load fragment default (CafeListFragment) saat pertama kali aplikasi dibuka
        if (savedInstanceState == null) {
            loadFragment(CafeListFragment())
        }
    }

    // Fungsi untuk mengganti fragment
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
