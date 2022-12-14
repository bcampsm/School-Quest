package com.example.schoolquest.utils

import android.app.AlertDialog
import android.content.Context

object Common {

    fun checkCredencials(email: String, password: String, ctx: Context): Boolean{ //Funció que verifica email y contrasenya.
        val pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`\\{|\\}~]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\$".toRegex()

        //Verificar format del correu
        if (pattern.containsMatchIn(email)) {
            //Verificar que la contrasenya no sigui buida
            return when (password) {
                "" -> {
                    dialogBuilder("La contrasenya no pot ser buida","Error", ctx)
                    false

                }
                else -> {
                    true
                }
            }
        } else {
            dialogBuilder("El correu no te un format válid", "Error", ctx)
            return false

        }
    }

    fun dialogBuilder(message: String, title: String, ctx: Context) {
        val dialog = AlertDialog.Builder(ctx)
            .setTitle(title)
            .setMessage(message)
            .create()
        dialog.show()
    }
}