package com.example.schoolquest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolquest.R
import com.example.schoolquest.databinding.FragmentPerfilProfessorBinding
import com.example.schoolquest.databinding.FragmentTasquesAlumneBinding
import com.example.schoolquest.utils.Alumnes
import com.example.schoolquest.utils.AlumnesAdapter
import com.example.schoolquest.utils.Tasques
import com.example.schoolquest.utils.TasquesAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//Inicialitzar adaptador, recyclerView i array d'informació pel recycler
private lateinit var adapter: AlumnesAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var alumnesArrayList: ArrayList<Alumnes>

/**
 * A simple [Fragment] subclass.
 * Use the [Perfil_Professor.newInstance] factory method to
 * create an instance of this fragment.
 */
class Perfil_Professor : Fragment() {
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

    // binding només es pot utilitzar entre onCreateVew i onDestroyView
    private var _binding: FragmentPerfilProfessorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar vista amb binding
        _binding = FragmentPerfilProfessorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Inicialitza dades i recycler view
        initializeData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = binding.rvAlumnes
        recyclerView.layoutManager = layoutManager
        adapter = AlumnesAdapter(alumnesArrayList)
        recyclerView.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Perfil_Professor.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Perfil_Professor().apply {
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
        val rvAlumnes = binding.rvAlumnes
        // Inicialitzar tasques
        alumnesArrayList = Alumnes.crearAlumnes()
        // Crea l'adaptador passant les dades ficticies
        val adapter = AlumnesAdapter(alumnesArrayList)
        // Linkar l'adaptador amb el recyclerView
        rvAlumnes.adapter = adapter
        // Posicionar els elements amb el LayoutManager
        rvAlumnes.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}