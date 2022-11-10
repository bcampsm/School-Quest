package com.example.schoolquest

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.inflate
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import com.example.schoolquest.R.style.Theme_SchoolQuest
import com.example.schoolquest.databinding.ActivityRecuperarContrassenyaBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Recuperar_Contrassenya : AppCompatActivity() {

    private lateinit var binding: ActivityRecuperarContrassenyaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        val binding = ActivityRecuperarContrassenyaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Listener per al boto
        binding.ButtonRecuperarContrasenya.setOnClickListener {
            val email: String =
                binding.textFieldRecuperarContrasenya.text.toString()

            //Notificar que el correu s'ha enviat
            Firebase.auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Common.dialogBuilder("Enllaç per recuperar la contrassenya enviat al email", "Revisa el teu email", this)
                    }
                }
        }
    }
}