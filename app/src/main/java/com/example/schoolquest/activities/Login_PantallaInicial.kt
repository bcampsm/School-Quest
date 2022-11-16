package com.example.schoolquest.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.schoolquest.R.style.Theme_SchoolQuest
import com.example.schoolquest.databinding.ActivityLoginPantallaInicialBinding

class Login_PantallaInicial : AppCompatActivity() {

    private lateinit var binding: ActivityLoginPantallaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(Theme_SchoolQuest)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginPantallaInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA,)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA), 101)
        }

        //Botó per obrir Login_Alumne.kt
        binding.ButtonLogin1.setOnClickListener {
            val intent = Intent(this, Login_Alumne::class.java)
            startActivity(intent)
        }

        //Botó per obrir login_professor.kt
        binding.ButtonLogin2.setOnClickListener {
            val intent = Intent(this, login_professor::class.java)
            startActivity(intent)
        }
    }
}