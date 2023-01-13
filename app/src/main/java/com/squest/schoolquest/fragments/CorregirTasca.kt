package com.squest.schoolquest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squest.schoolquest.databinding.FragmentCorregirTascaBinding
import com.squest.schoolquest.utils.Correccions
import com.squest.schoolquest.utils.CorregirAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//Inicialitzar adaptador, recyclerView i array d'informació pel recycler
private lateinit var adapter: CorregirAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var correccionsArrayList: ArrayList<Correccions>

/**
 * A simple [Fragment] subclass.
 * Use the [CorregirTasca.newInstance] factory method to
 * create an instance of this fragment.
 */
class CorregirTasca : Fragment() {
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
    private var _binding: FragmentCorregirTascaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar vista amb binding
        _binding = FragmentCorregirTascaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Inicialitza dades i recycler view
        initializeData()
        val layoutManager = GridLayoutManager(context, 3)
        recyclerView = binding.rvCorreccions
        recyclerView.layoutManager = layoutManager
        adapter = CorregirAdapter(correccionsArrayList)
        recyclerView.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CorregirTasca.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CorregirTasca().apply {
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
        val rvCorreccions = binding.rvCorreccions
        // Inicialitzar tasques
        correccionsArrayList = Correccions.crearCorreccions()
        // Crea l'adaptador passant les dades ficticies
        val adapter = CorregirAdapter(correccionsArrayList)
        // Linkar l'adaptador amb el recyclerView
        rvCorreccions.adapter = adapter
        // Posicionar els elements amb el LayoutManager
        rvCorreccions.layoutManager = GridLayoutManager(context, 3)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}