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
import com.example.schoolquest.databinding.TasquesAlumneCardsBinding

/**
 * Adaptador de tasques disponibles als alumnes
 *
 * @property mTasques
 */
class TasquesAdapter (private val mTasques: List<Tasques>) : RecyclerView.Adapter<TasquesAdapter.ViewHolder>() {

    /**
     * Invoca el binding
     *
     * @constructor
     * ViewHolder
     *
     * @param itemView
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = TasquesAlumneCardsBinding.bind(itemView)
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
        val contactView = inflater.inflate(R.layout.tasques_alumne_cards, parent, false)
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
        val tasca: Tasques = mTasques[position]

        // Asignar les dades a cada element
        viewHolder.binding.NomTasca.text = tasca.Nom
        viewHolder.binding.DescripcioTasca.text = tasca.Desc
        viewHolder.binding.vencimentTasca.text = tasca.Venc
        viewHolder.binding.buttonXP.text = tasca.XP
        viewHolder.binding.buttonSP.text = tasca.SP
        viewHolder.binding.progressBarTasquesCompletat.progress = tasca.progress

        // Intent per obrir la camara
        viewHolder.binding.ButtonCard.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(MainActivity.miMainActivity, intent, 200, null)
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