package com.example.schoolquest.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.schoolquest.R
import com.example.schoolquest.R.style.Theme_SchoolQuest
import com.example.schoolquest.databinding.ActivityLoginPantallaInicialBinding

/**
 * Pantalla inicial on l'usuari indica si n'es un alumne o un professor
 *
 */
class Login_PantallaInicial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(Theme_SchoolQuest)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginPantallaInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Verificacio de permissos per utilitzar la camara
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA,
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA), 200
            )
        }

        //Botó per obrir Login_Alumne.kt
        binding.ButtonLogin1.setOnClickListener {
            val intent = Intent(this, Login_Alumne::class.java)
            startActivity(intent)
            overridePendingTransition(
                R.anim.slide_in_right,
                com.google.android.material.R.anim.abc_fade_out)
        }

        //Botó per obrir login_professor.kt
        binding.ButtonLogin2.setOnClickListener {
            val intent = Intent(this, login_professor::class.java)
            startActivity(intent)
            overridePendingTransition(
                R.anim.slide_in_right,
                com.google.android.material.R.anim.abc_fade_out)
        }
    }
}