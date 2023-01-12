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
import com.example.schoolquest.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    companion object {
        lateinit var miMainActivity2: MainActivity2
    }

    lateinit var binding: ActivityMain2Binding

    private lateinit var toogle: ActionBarDrawerToggle

    //Navigation Component
    private lateinit var navController: NavController
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

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment

        navController = navHostFragment.navController

        binding.navigationView2.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menuPerfil2 -> {
                    Navigation.findNavController(binding.fragmentContainerView2)
                        .navigate(R.id.action_global_perfil_Professor)
                }

                R.id.menuTasques2 -> {
                    Navigation.findNavController(binding.fragmentContainerView2)
                        .navigate(R.id.action_global_tasques_Professor)
                }

                R.id.menuCalendari2 -> {
                    Navigation.findNavController(binding.fragmentContainerView2)
                        .navigate(R.id.action_global_calendari_professor)
                }

                R.id.menuBotigaDeRecompenses2 -> {
                    Navigation.findNavController(binding.fragmentContainerView2)
                        .navigate(R.id.action_global_tenda_Professor)
                }

                R.id.menuSettings2 -> {
                    Navigation.findNavController(binding.fragmentContainerView2)
                        .navigate(R.id.action_global_configuracio2)
                }

                R.id.logOut2 -> {
                    val intent = Intent(this, Login_PantallaInicial::class.java)
                    startActivity(intent)
                    overridePendingTransition(
                        androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom,
                        com.google.android.material.R.anim.abc_fade_out)
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
            Navigation.findNavController(binding.fragmentContainerView2)
                .navigate(R.id.action_global_tasques_Professor)
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
        miMainActivity2 = this
    }
}
