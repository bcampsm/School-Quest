package com.example.schoolquest.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolquest.R
import com.example.schoolquest.databinding.TendaAlumneCardsBinding

class TendaProfessorAdapter (private val mRecompenses : List<Recompenses>) : RecyclerView.Adapter<TendaProfessorAdapter.ViewHolder>() {

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
    }

    // Returna la quantitat d'elements al recyclerView
    override fun getItemCount(): Int {
        return mRecompenses.size
    }
}