package com.squest.schoolquest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squest.schoolquest.R
import com.squest.schoolquest.databinding.FragmentTasquesProfessorBinding
import com.squest.schoolquest.utils.Tasques
import com.squest.schoolquest.utils.TasquesProfessorAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//Inicialitzar adaptador, recyclerView i array d'informació pel recycler
private lateinit var adapter: TasquesProfessorAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var tasquesArrayList: ArrayList<Tasques>

/**
 * A simple [Fragment] subclass.
 * Use the [Tasques_Professor.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tasques_Professor : Fragment() {
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



    private var _binding: FragmentTasquesProfessorBinding? = null

    // binding només es pot utilitzar entre onCreateVew i onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar vista amb binding
        _binding = FragmentTasquesProfessorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Inicialitza dades i recycler view
        initializeData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = binding.rvTasquesProfessor
        recyclerView.layoutManager = layoutManager
        adapter = TasquesProfessorAdapter(tasquesArrayList)
        recyclerView.adapter = adapter

        // Intent per obrir pantalla de creacio de tasques
        binding.AfegirTascaFAB.setOnClickListener() {
            Navigation.findNavController(it)
                .navigate(R.id.action_tasques_Professor_to_crear_Tasca)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tasques_Professor.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tasques_Professor().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    /**
     * Inicialitza les dades ficticies del recicler view
     */
    private fun initializeData() {
        // Trobar el recyclerView a l'activity layout
        val rvTasques = binding.rvTasquesProfessor
        // Inicialitzar tasques
        tasquesArrayList = Tasques.crearTasca()
        // Crea l'adaptador passant les dades ficticies
        val adapter = TasquesProfessorAdapter(tasquesArrayList)
        // Linkar l'adaptador amb el recyclerView
        rvTasques.adapter = adapter
        // Posicionar els elements amb el LayoutManager
        rvTasques.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}