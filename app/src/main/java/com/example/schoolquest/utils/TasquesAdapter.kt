package com.example.schoolquest.utils

import android.content.Intent
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolquest.R
import com.example.schoolquest.activities.MainActivity
import com.example.schoolquest.fragments.Tasques_Alumne

class TasquesAdapter (private val mTasques: List<Tasques>) : RecyclerView.Adapter<TasquesAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nomTasca = itemView.findViewById<TextView>(R.id.NomTasca)
        val descTasca = itemView.findViewById<TextView>(R.id.DescripcioTasca)
        val vencTasca = itemView.findViewById<TextView>(R.id.vencimentTasca)
        val enviar = itemView.findViewById<Button>(R.id.ButtonCard)
        val XPbutton = itemView.findViewById<Button>(R.id.buttonXP)
        val SPbutton = itemView.findViewById<Button>(R.id.buttonSP)
        val progress = itemView.findViewById<ProgressBar>(R.id.progressBarTasquesCompletat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.tasques_alumne_cards, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get the data model based on position
        val tasca: Tasques = mTasques[position]
        // Set item views based on your views and data model
        val nomTasca = viewHolder.nomTasca
        nomTasca.text = tasca.Nom
        val descTasca = viewHolder.descTasca
        descTasca.text = tasca.Desc
        val vencTasca = viewHolder.vencTasca
        vencTasca.text = tasca.Venc
        val XPbutton = viewHolder.XPbutton
        XPbutton.text = tasca.XP
        val SPbutton = viewHolder.SPbutton
        SPbutton.text = tasca.SP
        val progress = viewHolder.progress
        progress.progress = tasca.progress

        val enviar = viewHolder.enviar
        // Open camera
        viewHolder.enviar.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(MainActivity.miMainActivity, intent, 200, null)
        }
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mTasques.size
    }
}