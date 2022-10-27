package com.example.schoolquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.schoolquest.R.style.Theme_SchoolQuest

class Login_PantallaInicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(Theme_SchoolQuest)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_pantalla_inicial)

        //Botó per obrir Login_Alumne.kt
        val buttonAlumne = findViewById<Button>(R.id.ButtonLogin1)
        buttonAlumne.setOnClickListener {
            val intent = Intent(this, Login_Alumne::class.java)
            startActivity(intent)
        }

        //Botó per obrir login_professor.kt
        val buttonProfessor = findViewById<Button>(R.id.ButtonLogin2)
        buttonProfessor.setOnClickListener {
            val intent = Intent(this, login_professor::class.java)
            startActivity(intent)
        }
    }
}