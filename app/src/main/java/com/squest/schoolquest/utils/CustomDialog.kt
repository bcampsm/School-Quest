package com.squest.schoolquest.utils

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import com.squest.schoolquest.R

/**
 * Clase per a crear el dialog per demanar una resenya a la PlayStore
 *
 * @constructor
 *
 * @param context
 */
class CustomDialog(context: Context) : AlertDialog.Builder(context) {

    private val appName = "com.squest.schoolquest" // Nom del package
    private val daysUntilPrompt = 0 // Nombre minim de dies (a 0 per anar més rápid)
    private val launchesUntilPrompt = 2 // Nombre minim de llançaments de l'aplicacio

    /**
     * Calcula les vegades que s'ha obert l'aplicacio i ho compara amb el primer dia que es va obrir
     * aquesta.
     *
     * @param title
     * @param message
     */
    fun appLaunched(title: String, message: String) {
        val prefs: SharedPreferences = context.getSharedPreferences("apprater", 0)
        // Boolea per a no demanar una resenya mai mes
        if (prefs.getBoolean("dontshowagain", false)) {
            return
        }
        val editor = prefs.edit()

        // Incrementa el contador de llançaments
        val launchCount = prefs.getLong("launchCount", 0) + 1
        editor.putLong("launchCount", launchCount)

        // Obté la data del primer llançament
        var dateFirstLaunch = prefs.getLong("dateFirstLaunch", 0)
        if (dateFirstLaunch == 0L) {
            dateFirstLaunch = System.currentTimeMillis()
            editor.putLong("dateFirstLaunch", dateFirstLaunch)
        }

        // Espera n dies abans de preguntar a l'usuari.
        if (launchCount >= launchesUntilPrompt) {
            if (System.currentTimeMillis() >= dateFirstLaunch +
                daysUntilPrompt * 24 * 60 * 60 * 1000
            ) {
                show(title, message, editor)
            }
        }
        editor.apply()
    }

    /**
     * Constructor del dialog per demanar la resenya de l'aplicacio
     *
     * @param title
     * @param message
     * @param editor
     */
    fun show(title: String, message: String, editor: SharedPreferences.Editor?) {
        // Crear el builder amb el titol, missatge i icona
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        // Envia a la página de la Play Store
        builder.setPositiveButton(context.getString(R.string.rateButton)) { _, _ ->
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$appName")
                )
            )
        }

        builder.setNeutralButton(context.getString(R.string.askLater)) { _, _ ->
            // No a de fer res
        }

        // Cancela per sempre
        builder.setNegativeButton(context.getString(R.string.noThanks)) { _, _ ->
            if (editor != null) {
                    editor.putBoolean("dontshowagain", true)
                    editor.commit()
                }
        }

        // Crea el dialog
        val alertDialog: AlertDialog = builder.create()

        // Propietats del dialog
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}
