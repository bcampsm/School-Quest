package com.example.schoolquest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolquest.R
import com.example.schoolquest.databinding.ActivityMainBinding
import com.example.schoolquest.databinding.FragmentTasquesAlumneBinding
import com.example.schoolquest.utils.Contact
import com.example.schoolquest.utils.TasquesAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var adapter : TasquesAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var tasquesArrayList: ArrayList<Contact>

/**
 * A simple [Fragment] subclass.
 * Use the [Tasques_Alumne.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tasques_Alumne : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var _binding: FragmentTasquesAlumneBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTasquesAlumneBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = binding.rvTasques
        recyclerView.layoutManager = layoutManager
        adapter = TasquesAdapter(tasquesArrayList)
        recyclerView.adapter = adapter
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

    private fun initializeData(){
        // Lookup the recyclerview in activity layout
        val rvTasques = binding.rvTasques as RecyclerView
        // Initialize contacts
        tasquesArrayList = Contact.createContactsList(20)
        // Create adapter passing in the sample user data
        val adapter = TasquesAdapter(tasquesArrayList)
        // Attach the adapter to the recyclerview to populate items
        rvTasques.adapter = adapter
        // Set layout manager to position the items
        rvTasques.layoutManager = LinearLayoutManager(context)
        // That's all!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}