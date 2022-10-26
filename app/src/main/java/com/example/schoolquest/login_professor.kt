package com.example.schoolquest

import android.app.AlertDialog
import android.content.ContentValues.TAG
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
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class login_professor : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_professor)

        auth = Firebase.auth
        val btEnviar = findViewById<Button>(R.id.ButtonLoginProfessor1)

        btEnviar.setOnClickListener {
            val email: String =
                findViewById<TextInputEditText>(R.id.textFieldLoginProfessorEmail).text.toString()
            val password: String =
                findViewById<TextInputEditText>(R.id.textFieldLoginProfessorPassword).text.toString()

            checkCredencials(email, password)
        }
    }

    private fun checkCredencials(email: String, password: String) {
        //Verificar format del correu
        val pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`\\{|\\}~]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\$".toRegex()
        if (pattern.containsMatchIn(email)) {
            //Verificar que la contrasenya no sigui vuida
            when (password) {
                "" -> {
                    dialogBuilder("La contrasenya no pot ser vuida")
                }
                else -> {
                    loginProfessor(email, password)
                }
            }
        } else {
            dialogBuilder("El correu no te un format válid")
        }
    }

    private fun dialogBuilder(message: String) {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage(message)
            .create()
        dialog.show()
    }

    private fun loginProfessor(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    Snackbar.make(this.findViewById(android.R.id.content), "Login con éxito.", Snackbar.LENGTH_SHORT)
                        .show()
                } else {
                    // If sign in fails, display a message to the user.
                    Snackbar.make(this.findViewById(android.R.id.content), "Error d'autenticacio", Snackbar.LENGTH_SHORT)
                        .show() //TODO()
                }
            }
    }
}