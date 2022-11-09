package com.example.schoolquest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tasques_Alumne.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tasques_Alumne : Fragment() {
    private var _binding: Tasques_Alumne? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    // Keeps track of which LayoutManager is in use for the [RecyclerView]
    private var isLinearLayoutManager = true

    lateinit var Tasques: ArrayList<Contact>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
//        // Lookup the recyclerview in activity layout
//        val rvTasques = findViewById<View>(R.id.rvTasques) as RecyclerView
//        // Initialize contacts
//        Tasques = Contact.createContactsList(20)
//        // Create adapter passing in the sample user data
//        val adapter = TasquesAdapter(Tasques)
//        // Attach the adapter to the recyclerview to populate items
//        rvTasques.adapter = adapter
//        // Set layout manager to position the items
//        rvTasques.layoutManager = LinearLayoutManager(this)
//        // That's all!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasques__alumne, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.also { this.recyclerView = it }
        // Sets the LayoutManager of the recyclerview
        // On the first run of the app, it will be LinearLayoutManager
        chooseLayout()
    }

    /**
     * Frees the binding object when the Fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Sets the LayoutManager for the [RecyclerView] based on the desired orientation of the list.
     *
     * Notice that because the enclosing class has changed from an Activity to a Fragment,
     * the signature of the LayoutManagers has to slightly change.
     */
    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        } else {
            recyclerView.layoutManager = GridLayoutManager(context, 20)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tasques_Alumne.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tasques_Alumne().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}