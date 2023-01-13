package com.squest.schoolquest.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squest.schoolquest.R
import com.squest.schoolquest.databinding.TendaAlumneCardsBinding
import com.google.android.material.snackbar.Snackbar

/**
 * Adaptador de recompenses disponibles pels alumnes
 *
 * @property mRecompenses
 */
class TendaAdapter (private val mRecompenses : List<Recompenses>) : RecyclerView.Adapter<TendaAdapter.ViewHolder>() {

    /**
     * Invoca el binding
     *
     * @constructor
     * ViewHolder
     *
     * @param itemView
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = TendaAlumneCardsBinding.bind(itemView)
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
        val contactView = inflater.inflate(R.layout.tenda_alumne_cards, parent, false)
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

    /**
     * Retorna la quantitat d'elements a la llista
     *
     * @return Int
     */
    override fun getItemCount(): Int {
        return mRecompenses.size
    }
}