package com.example.schoolquest.utils

annotation class Comments()

//Antiga funció de login alumne y login profesor
    /*private fun checkCredencials(email: String, password: String) {
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
    }*/
    /*public fun checkCredencials(email: String, password: String) {
        //Verificar format del correu
        val pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`\\{|\\}~]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\$".toRegex()
        if (pattern.containsMatchIn(email)) {
            //Verificar que la contrasenya no sigui vuida
            when (password) {
                "" -> {
                    dialogBuilder("La contrasenya no pot ser vuida")
                }
                else -> {
                    loginUsuari(email, password)
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
    }*/
