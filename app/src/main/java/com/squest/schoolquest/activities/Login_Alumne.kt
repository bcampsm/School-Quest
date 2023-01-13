package com.squest.schoolquest.activities

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squest.schoolquest.R
import com.squest.schoolquest.utils.Common
import com.squest.schoolquest.databinding.ActivityLoginAlumneBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * Pantalla on l'usuari alumne introdueix les seves credencials per iniciar sessió
 *
 */
class Login_Alumne : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginAlumneBinding

    /**
     * Codi principal de la pantalla on es controlen els botons i camps de text
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityLoginAlumneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        //Botó que envia els valors dels textFields
        binding.ButtonLoginAlumne1.setOnClickListener {
            val email: String =
                binding.textFieldLoginAlumneEmail.text.toString()
            val password: String =
                binding.textFieldLoginAlumnePassword.text.toString()

            //Crida a metode per verificar credencials
            if (Common.checkCredencials(email, password, this)) {
                loginUsuari(email, password)
                /*
                Saltar-se el metode de login amb firebase, utilitzat quan es fan tests amb l'emulador
                ja que tarda molt en fer connexions a la base de dades (problema global amb Android Studio).
                 */
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                overridePendingTransition(
//                    androidx.appcompat.R.anim.abc_slide_in_bottom,
//                    com.google.android.material.R.anim.abc_fade_out)
            }
        }
    }

    /**
     * Aplica animacions quan l'usuari torna enrere
     *
     */
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(
            androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom,
            R.anim.slide_out_right)
    }

    /**
     * Verifica si l'usuari ha pogut iniciar sessió
     *
     * @param email
     * @param password
     */
    private fun loginUsuari(email: String, password: String) {
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
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(
                        androidx.appcompat.R.anim.abc_slide_in_bottom,
                        com.google.android.material.R.anim.abc_fade_out)
                } else {
                    //Si les credencials son incorrectes o hi ha un error de connexió, mostra aquest missatge
                    Snackbar.make(
                        binding.root,
                        "Error d'autenticacio.",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
    }
}