package com.example.schoolquest.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolquest.R
import com.example.schoolquest.databinding.TasquesProfessorCardsBinding
import com.google.android.material.snackbar.Snackbar

class TasquesProfessorAdapter (private val mTasques: List<Tasques>) : RecyclerView.Adapter<TasquesProfessorAdapter.ViewHolder>() {

    // Invocar el binding
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = TasquesProfessorCardsBinding.bind(itemView)
    }

    // Inflar layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.tasques_professor_cards, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Afegir les dades a cada tarjeta del recyclerView
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Obtenir el model de dades
        val tasca: Tasques = mTasques[position]

        // Asignar les dades a cada element
        viewHolder.binding.NomTasca.text = tasca.Nom
        viewHolder.binding.DescripcioTasca.text = tasca.Desc
        viewHolder.binding.vencimentTasca.text = tasca.Venc
        viewHolder.binding.buttonXP.text = tasca.XP
        viewHolder.binding.buttonSP.text = tasca.SP
        viewHolder.binding.progressBarTasquesCompletat.progress = tasca.progress

        // Intent per obrir el fragment de correccio (proximament)
        viewHolder.binding.ButtonCard.setOnClickListener() {

            Navigation.findNavController(it)
                .navigate(R.id.action_tasques_Professor_to_corregirTasca)
        }


    }

    // Returna la quantitat d'elements al recyclerView
    override fun getItemCount(): Int {
        return mTasques.size
    }
}