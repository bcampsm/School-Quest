package com.example.schoolquest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.schoolquest.R
import com.example.schoolquest.databinding.ActivityMainBinding
import com.example.schoolquest.fragments.*
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    //Navigation Component
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    private lateinit var fragment: androidx.fragment.app.Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toogle = ActionBarDrawerToggle(this, binding.drawerLayout,
            R.string.openDrawer,
            R.string.CloseDrawer
        )
        binding.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Navigation Component
        fragment = Tasques_Alumne()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
        //

        binding.navigationView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.menuPerfil -> fragment = Perfil_Alumne()

                R.id.menuTasques -> fragment = Tasques_Alumne()

                R.id.menuCalendari -> fragment = Calendari_alumne()

                R.id.menuBotigaDeRecompenses -> fragment = Tenda_Alumnes()

                R.id.menuSettings -> fragment = Configuracio()

                R.id.logOut -> {

                    Snackbar.make(
                        binding.root,
                        "LOG OUT",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
            binding.drawerLayout.openDrawer(GravityCompat.START)
                true
            }

        //Navigation Component
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, Tasques_Alumne())
        transaction.addToBackStack(null)
        transaction.commit()
        }
        //

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (toogle.onOptionsItemSelected(item)){
                return true
            }
            return super.onOptionsItemSelected(item)
        }
    }
