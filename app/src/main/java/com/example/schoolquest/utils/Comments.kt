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

//Antigua navegación
/*
            binding.navigationView2.postDelayed(
                {
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, fragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }, 275
            )

 */

//Navigation Component antiguo
/*
fragment = Tasques_Professor()// A la variable "fragment" la igualem al fragment que primerament volem mostrar
var fragmentTransaction = supportFragmentManager.beginTransaction()
fragmentTransaction.replace(R.id.fragmentContainerView, fragment)//fem un remplaç del fragment actual que es mostra al fragment container view, per el que hem associat previament a la variable fragment.
fragmentTransaction.addToBackStack(null)//afegim els fragments a darrere
fragmentTransaction.commit()

//Navigation Component
    val fragmentManager = supportFragmentManager
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    private lateinit var navGraph: NavGraph
    //
 */
//

