package com.example.schoolquest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.schoolquest.R
import com.example.schoolquest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var miMainActivity: MainActivity
    }

    //Binding
    lateinit var binding: ActivityMainBinding
    //

    private lateinit var toogle: ActionBarDrawerToggle

    //Navigation Component
    private lateinit var navController: NavController
    //

    override fun onCreate(savedInstanceState: Bundle?) {//onCreate
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        miMainActivity = this

        toogle = ActionBarDrawerToggle(
            this, binding.drawerLayout,
            R.string.openDrawer,
            R.string.CloseDrawer
        )
        binding.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        //Listener del menu lateral
        binding.navigationView.setNavigationItemSelectedListener {//Menu lateral, per a cada click en cadscun dels items, igualem la variable fragment amb el fragment que l'usuari selecciona amb el menu

            when (it.itemId) {

                R.id.menuPerfil -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.action_global_perfil_Alumne)
                }

                R.id.menuTasques -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.action_global_tasques_Alumne)
                }

                R.id.menuCalendari -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.action_global_calendari_alumne)
                }

                R.id.menuBotigaDeRecompenses -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.action_global_tenda_Alumnes)
                }

                R.id.menuSettings -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.action_global_configuracio2)
                }

                R.id.logOut -> {
                    val intent = Intent(this, Login_PantallaInicial::class.java)
                    startActivity(intent)
                    overridePendingTransition(
                        androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom,
                        com.google.android.material.R.anim.abc_fade_out)
                }
            }
            binding.drawerLayout.openDrawer(GravityCompat.START)

//            binding.navigationView.postDelayed(
//                {
//                    val transaction = fragmentManager.beginTransaction()
//                    transaction.replace(R.id.fragmentContainerView, fragment)
//                    transaction.addToBackStack(null)
//                    transaction.commit()
//                }, 275
//            )
            //Navigation Component

            binding.drawerLayout.close()

            true
        }

        binding.navigationView.postDelayed({
            Navigation.findNavController(binding.fragmentContainerView)
                .navigate(R.id.action_global_tasques_Alumne)
        }, 1)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        miMainActivity = this
    }
}
