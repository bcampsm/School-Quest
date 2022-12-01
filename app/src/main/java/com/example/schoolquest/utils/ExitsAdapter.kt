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

class ExitsAdapter (private val mExits: List<Exits>) : RecyclerView.Adapter<ExitsAdapter.ViewHolder>() {

    // Invocar el binding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ExitsAlumneCardsBinding.bind(itemView)
    }

    // Inflar layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.exits_alumne_cards, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Afegir les dades a cada tarjeta del recyclerView
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Obtenir dades del model
        val exits: Exits = mExits[position]

        // Asignar les dades a cada element
        viewHolder.binding.nomExit.text = exits.Nom
        viewHolder.binding.exitIcon.isEnabled = exits.Completat
    }

    // Returna la quantitat d'elements al recyclerView
    override fun getItemCount(): Int {
        return mExits.size
    }
}