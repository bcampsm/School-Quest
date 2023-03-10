package com.squest.schoolquest.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squest.schoolquest.R
import com.squest.schoolquest.databinding.TasquesProfessorCardsBinding

/**
 * Adaptador de tasques creades pel professor
 *
 * @property mTasques
 */
class TasquesProfessorAdapter (private val mTasques: List<Tasques>) : RecyclerView.Adapter<TasquesProfessorAdapter.ViewHolder>() {

    /**
     * Invoca el binding
     *
     * @constructor
     * ViewHolder
     *
     * @param itemView
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = TasquesProfessorCardsBinding.bind(itemView)
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
        val contactView = inflater.inflate(R.layout.tasques_professor_cards, parent, false)
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

    /**
     * Retorna la quantitat d'elements a la llista
     *
     * @return Int
     */
    override fun getItemCount(): Int {
        return mTasques.size
    }
}