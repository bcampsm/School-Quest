package com.example.schoolquest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.schoolquest.R
import com.example.schoolquest.databinding.ActivityMain2Binding
import com.example.schoolquest.fragments.*
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {

    companion object {
        lateinit var miMainActivity2: MainActivity2
    }

    private lateinit var toogle: ActionBarDrawerToggle

    //Navigation Component
    val fragmentManager = supportFragmentManager
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    private lateinit var navGraph: NavGraph
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        miMainActivity2 = this

        toogle = ActionBarDrawerToggle(
            this, binding.drawerLayout2,
            R.string.openDrawer,
            R.string.CloseDrawer
        )
        binding.drawerLayout2.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        //Navigation Component
//        fragment = Tasques_Professor()// A la variable "fragment" la igualem al fragment que primerament volem mostrar
//        var fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)//fem un remplaç del fragment actual que es mostra al fragment container view, per el que hem associat previament a la variable fragment.
//        fragmentTransaction.addToBackStack(null)//afegim els fragments a darrere
//        fragmentTransaction.commit()
//        //

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment

        val graphInflater = navHostFragment.navController.navInflater//
        //navGraph = graphInflater.inflate(R.navigation.nav_graph)//

       // navGraph=findNavController(R.id.tasques_Professor)
        navController = navHostFragment.navController

        //navGraph.setStartDestination(R.id.tasques_Professor)



        binding.navigationView2.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menuPerfil2 -> {
                    Navigation.findNavController(binding.fragmentContainerView2).navigate(R.id.action_global_perfil_Professor)
                }

                R.id.menuTasques2 -> {
                    Navigation.findNavController(binding.fragmentContainerView2).navigate(R.id.action_global_tasques_Professor)
                }

                R.id.menuCalendari2 -> {
                    Navigation.findNavController(binding.fragmentContainerView2).navigate(R.id.action_global_calendari_professor)
                }

                R.id.menuBotigaDeRecompenses2 -> {
                    Navigation.findNavController(binding.fragmentContainerView2).navigate(R.id.action_global_tenda_Professor)
                }

                R.id.menuSettings2 -> {
                    Navigation.findNavController(binding.fragmentContainerView2).navigate(R.id.action_global_configuracio2)
                }

                R.id.logOut2 -> {
                    val intent = Intent(this, Login_PantallaInicial::class.java)
                    startActivity(intent)
                }
            }
            binding.drawerLayout2.openDrawer(GravityCompat.START)

//            binding.navigationView2.postDelayed(
//                {
//                    val transaction = fragmentManager.beginTransaction()
//                    transaction.replace(R.id.fragmentContainerView, fragment)
//                    transaction.addToBackStack(null)
//                    transaction.commit()
//                }, 275
//            )
            //Navigation Component

            binding.drawerLayout2.close()



            true
        }

        binding.navigationView2.postDelayed({
            Navigation.findNavController(binding.fragmentContainerView2).navigate(R.id.action_global_tasques_Professor)
        }, 1)

       // Navigation.findNavController(binding.fragmentContainerView2).navigate(R.id.action_global_tasques_Professor)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        MainActivity2.miMainActivity2 = this
    }
}