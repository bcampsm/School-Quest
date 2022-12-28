package com.example.schoolquest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schoolquest.utils.Common
import com.example.schoolquest.databinding.ActivityRecuperarContrassenyaBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * Pantalla on l'usuari pot recuperar la seva contrasenya si l'ha perdut
 *
 */
class Recuperar_Contrassenya : AppCompatActivity() {

    /**
     * Codi principal on es controla el boto i camp de text per recuperar la contrasenya,
     * indicant amb un missatge si la tasca ha sigut exitosa
     *
     * @param savedInstanceState
     */
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
                        Common.dialogBuilder(
                            "Enllaç per recuperar la contrassenya enviat al email",
                            "Revisa el teu email",
                            this
                        )
                    }
                }
        }
    }
}