package com.example.schoolquest.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.schoolquest.R
import com.example.schoolquest.databinding.ActivityMainBinding
import com.example.schoolquest.fragments.*
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var miMainActivity: MainActivity
    }

    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    //Navigation Component
    val fragmentManager = supportFragmentManager
    lateinit var fragment: Fragment
    //

    override fun onCreate(savedInstanceState: Bundle?) {//onCreate
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
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

        //Navigation Component
        fragment = Tasques_Alumne()// A la variable "fragment" la igualem al fragment que primerament volem mostrar
        var fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)//fem un remplaç del fragment actual que es mostra al fragment container view, per el que hem associat previament a la variable fragment.
        fragmentTransaction.addToBackStack(null)//afegim els fragments a darrere
        fragmentTransaction.commit()
        //

        binding.navigationView.setNavigationItemSelectedListener {//Menu lateral, per a cada click en cadscun dels items, igualem la variable fragment amb el fragment que l'usuari selecciona amb el menu

            when (it.itemId) {

                R.id.menuPerfil -> fragment = Perfil_Alumne()

                R.id.menuTasques -> fragment = Tasques_Alumne()

                R.id.menuCalendari -> fragment = Calendari_alumne()

                R.id.menuBotigaDeRecompenses -> fragment = Tenda_Alumnes()

                R.id.menuSettings -> fragment = Configuracio()

                R.id.logOut -> {//log out no implementt, nomes mostra un snackbar

                    Snackbar.make(
                        binding.root,
                        "LOG OUT",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
            binding.drawerLayout.openDrawer(GravityCompat.START)
            binding.navigationView.postDelayed(
                {
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, fragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }, 275
            )
            //Navigation Component

            binding.drawerLayout.close()

            true
        }

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

