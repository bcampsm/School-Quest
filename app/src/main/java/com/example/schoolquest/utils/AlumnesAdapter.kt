package com.example.schoolquest.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolquest.R
import com.example.schoolquest.databinding.LlistaAlumnesCardsBinding

class AlumnesAdapter (private val mAlumnes: List<Alumnes>) : RecyclerView.Adapter<AlumnesAdapter.ViewHolder>() {

    // Invocar el binding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = LlistaAlumnesCardsBinding.bind(itemView)
    }

    // Inflar layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.llista_alumnes_cards, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Afegir les dades a cada tarjeta del recyclerView
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Obtenir dades del model
        val alumne: Alumnes = mAlumnes[position]

        // Asignar les dades a cada element
        viewHolder.binding.nomAlumne.text = alumne.Nom
    }

    // Returna la quantitat d'elements al recyclerView
    override fun getItemCount(): Int {
        return mAlumnes.size
    }
}