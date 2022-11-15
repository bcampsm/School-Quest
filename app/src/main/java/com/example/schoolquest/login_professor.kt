package com.example.schoolquest

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.inflate
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import com.example.schoolquest.R.style.Theme_SchoolQuest
import com.example.schoolquest.databinding.ActivityLoginProfessorBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class login_professor : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginProfessorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityLoginProfessorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        //Botó que envia els valors dels textFields
        binding.ButtonLoginProfessor1.setOnClickListener {
            val email: String =
                binding.textFieldLoginProfessorEmail.text.toString()
            val password: String =
                binding.textFieldLoginProfessorPassword.text.toString()

            //Crida a metode per verificar credencials
            if (Common.checkCredencials(email, password, this)) {
                loginProfessor(email, password)
            }
        }

        //Crida a la pantalla de recuperar contrasenya
        binding.recuperarContrasenya.setOnClickListener {
            val intent = Intent(this, Recuperar_Contrassenya::class.java)
            startActivity(intent)
        }
    }

    //Metode per verificar si l'usuari ha pogut iniciar sessió
    private fun loginProfessor(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //Inici de sessió amb éxit, envia l'usuari a la pantalla principal de tasques
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    Snackbar.make(
                        binding.root,
                        "Login con éxito.",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                } else {
                    //Si les credencials son incorrectes o hi ha un error de connexió, mostra aquest missatge
                    Snackbar.make(
                        binding.root,
                        "Error d'autenticacio",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
    }
}