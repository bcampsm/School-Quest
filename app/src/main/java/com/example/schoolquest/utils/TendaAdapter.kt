package com.example.schoolquest.utils

import android.content.Intent
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolquest.R
import com.example.schoolquest.activities.MainActivity
import com.example.schoolquest.databinding.ExitsAlumneCardsBinding
import com.example.schoolquest.databinding.TasquesAlumneCardsBinding
import com.example.schoolquest.databinding.TendaAlumneCardsBinding
import com.google.android.material.snackbar.Snackbar

class TendaAdapter (private val mRecompenses : List<Recompenses>) : RecyclerView.Adapter<TendaAdapter.ViewHolder>() {

    // Invocar el binding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = TendaAlumneCardsBinding.bind(itemView)
    }

    // Inflar layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.tenda_alumne_cards, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Afegir les dades a cada tarjeta del recyclerView
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Obtenir dades del model
        val recompenses: Recompenses = mRecompenses[position]

        // Asignar les dades a cada element
        viewHolder.binding.nomRecompensa.text = recompenses.Nom
        viewHolder.binding.preuRecompensa.text = recompenses.Preu.toString() + " SP"

        viewHolder.binding.imageView3.setOnClickListener() {
            Snackbar.make(
                it,
                "Compra",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    // Returna la quantitat d'elements al recyclerView
    override fun getItemCount(): Int {
        return mRecompenses.size
    }
}