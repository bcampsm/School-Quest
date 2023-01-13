package com.squest.schoolquest.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squest.schoolquest.R
import com.squest.schoolquest.databinding.LlistaAlumnesCardsBinding

/**
 * Adaptador del llistat d'alumnes al perfil del professor
 *
 * @property mAlumnes
 */
class AlumnesAdapter (private val mAlumnes: List<Alumnes>) : RecyclerView.Adapter<AlumnesAdapter.ViewHolder>() {

    /**
     * Invoca el binding
     *
     * @constructor
     * ViewHolder
     *
     * @param itemView
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = LlistaAlumnesCardsBinding.bind(itemView)
    }

    /**
     * Infla el layout del fragment
     *
     * @param parent
     * @param viewType
     * @return ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.llista_alumnes_cards, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    /**
     * Inserta les dades en els camps corresponents del recycler view
     *
     * @param viewHolder
     * @param position
     */
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Obtenir dades del model
        val alumne: Alumnes = mAlumnes[position]

        // Asignar les dades a cada element
        viewHolder.binding.nomAlumne.text = alumne.Nom
    }

    /**
     * Retorna la quantitat d'elements a la llista
     *
     * @return Int
     */
    override fun getItemCount(): Int {
        return mAlumnes.size
    }
}