// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    // Plugin untuk aplikasi Android dan Kotlin
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

    // Plugin untuk Google services
    id("com.google.gms.google-services") version "4.4.2" apply false
}

// Tambahkan dependencies yang dibutuhkan di sini jika ada.
