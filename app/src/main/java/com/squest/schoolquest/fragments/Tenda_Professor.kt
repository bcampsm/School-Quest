package com.squest.schoolquest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squest.schoolquest.R
import com.squest.schoolquest.databinding.FragmentTendaProfessorBinding
import com.squest.schoolquest.utils.Recompenses
import com.squest.schoolquest.utils.TendaProfessorAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//Inicialitzar adaptador, recyclerView i array d'informació pel recycler
private lateinit var adapter: TendaProfessorAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var recompensesArrayList: ArrayList<Recompenses>

/**
 * A simple [Fragment] subclass.
 * Use the [Tenda_Professor.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tenda_Professor : Fragment() {
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
    private var _binding: FragmentTendaProfessorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTendaProfessorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Inicialitza dades i recycler view
        initializeData()
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView = binding.rvRecompensesProfessor
        recyclerView.layoutManager = layoutManager
        adapter = TendaProfessorAdapter(recompensesArrayList)
        recyclerView.adapter = adapter

        // Intent per obrir pantalla de creacio de recompenses
        binding.AfegirRecompensaFAB.setOnClickListener() {
            Navigation.findNavController(it)
                .navigate(R.id.action_tenda_Professor_to_crear_Recompensa)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tenda_Professor.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tenda_Professor().apply {
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
        val rvRecompenses = binding.rvRecompensesProfessor
        // Inicialitzar tasques
        recompensesArrayList = Recompenses.crearRecompenses()
        // Crea l'adaptador passant les dades ficticies
        val adapter = TendaProfessorAdapter(recompensesArrayList)
        // Linkar l'adaptador amb el recyclerView
        rvRecompenses.adapter = adapter
        // Posicionar els elements amb el LayoutManager
        rvRecompenses.layoutManager = GridLayoutManager(context, 2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}