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
import com.example.schoolquest.databinding.CorregirTascaCardsBinding
import com.example.schoolquest.databinding.TasquesAlumneCardsBinding

class CorregirAdapter (private val mCorrecccions: List<Correccions>) : RecyclerView.Adapter<CorregirAdapter.ViewHolder>() {

    // Invocar el binding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CorregirTascaCardsBinding.bind(itemView)
    }

    // Inflar layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.corregir_tasca_cards, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Afegir les dades a cada tarjeta del recyclerView
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Obtenir dades del model
        val correccio: Correccions = mCorrecccions[position]

        // Asignar les dades a cada element
        viewHolder.binding.nomAlumne.text = correccio.Nom
        viewHolder.binding.corregit.isActivated = correccio.Corregit

    }

    // Returna la quantitat d'elements al recyclerView
    override fun getItemCount(): Int {
        return mCorrecccions.size
    }
}