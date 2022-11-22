package com.example.schoolquest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.schoolquest.R
import com.example.schoolquest.databinding.ActivityMain2Binding
import com.example.schoolquest.fragments.*
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {

    companion object {
        lateinit var miMainActivity2: MainActivity2
    }

    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMain2Binding

    //Navigation Component
    val fragmentManager = supportFragmentManager
    lateinit var fragment: Fragment
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
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

        //Navigation Component
        fragment = Tasques_Professor()// A la variable "fragment" la igualem al fragment que primerament volem mostrar
        var fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)//fem un remplaç del fragment actual que es mostra al fragment container view, per el que hem associat previament a la variable fragment.
        fragmentTransaction.addToBackStack(null)//afegim els fragments a darrere
        fragmentTransaction.commit()
        //

        binding.navigationView2.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menuPerfil2 -> fragment = Perfil_Professor()

                R.id.menuTasques2 -> fragment = Tasques_Professor()

                R.id.menuCalendari2 -> fragment = Calendari_professor()

                R.id.menuBotigaDeRecompenses2 -> fragment = Tenda_Professor()

                R.id.menuSettings2 -> fragment = Configuracio()

                R.id.logOut2 -> {//log out no implementt, nomes mostra un snackbar

                    Snackbar.make(
                        binding.root,
                        "LOG OUT",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
            binding.drawerLayout2.openDrawer(GravityCompat.START)

            binding.navigationView2.postDelayed(
                {
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, fragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }, 275
            )
            //Navigation Component

            binding.drawerLayout2.close()

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
        MainActivity2.miMainActivity2 = this
    }
}