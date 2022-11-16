package com.example.schoolquest.utils

import android.content.Intent
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolquest.R

class TasquesAdapter (private val mContacts: List<Contact>) : RecyclerView.Adapter<TasquesAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nameTextView = itemView.findViewById<TextView>(R.id.NomTasca)
        val messageButton = itemView.findViewById<Button>(R.id.ButtonCard)
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
        val contact: Contact = mContacts.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.nameTextView
        textView.text = contact.name
        val button = viewHolder.messageButton
        button.text = if (contact.isOnline) "Enviar" else "Offline"
        button.isEnabled = contact.isOnline

        //Obrir camara quan es prem el boto
//        viewHolder.messageButton.setOnClickListener {
//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(this, intent)
//        }
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mContacts.size
    }
}