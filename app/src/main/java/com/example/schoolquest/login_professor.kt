package com.example.schoolquest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class login_professor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_professor)
    }
}