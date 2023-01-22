package com.squest.schoolquest.fragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.firebase.firestore.FirebaseFirestore
import com.squest.schoolquest.R
import com.squest.schoolquest.databinding.FragmentCrearTascaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Crear_Tasca.newInstance] factory method to
 * create an instance of this fragment.
 */
class Crear_Tasca : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentCrearTascaBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private val db = FirebaseFirestore.getInstance()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCrearTascaBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val random = java.util.Random()
        val randomNumber = random.nextInt(99999) + 10000

        binding.buttonCrearTasca.setOnClickListener {


            db.collection("Tasks").document("Task"+randomNumber).set(
                hashMapOf("Name" to binding.textFieldNovaTasca.text.toString(),
                    "Description" to binding.textFieldDescripcio.text.toString(),
                    "StartDate" to binding.textFieldData.text.toString(),
                    "FinishDate" to binding.textFieldDataFinish.text.toString(),
                    "SP" to binding.textFieldSP.text.toString(),
                    "Experience" to binding.textFieldXP.text.toString(),
                    "StudentsFinished" to "0")
            )

            val documentReference = db.collection("Groups").document("GrupA")
            documentReference.get().addOnSuccessListener { documentSnapshot ->
                val myArrayField = documentSnapshot.get("Tasks") as ArrayList<Any>
                myArrayField.add("Task"+randomNumber)
                val newData = hashMapOf("Tasks" to myArrayField) as MutableMap<String, Any>
                documentReference.update(newData)
            }

            val dialog = AlertDialog.Builder(context)
                    .setTitle(getString(R.string.CreacioTasca))
                    .setMessage(getString(R.string.TascaCreada))
                    .create()
                dialog.show()


            Navigation.findNavController(it)
                .navigate(R.id.action_crear_Tasca_to_tasques_Professor)

        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Crear_Tasca.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Crear_Tasca().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}