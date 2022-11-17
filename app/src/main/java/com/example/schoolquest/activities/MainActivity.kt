package com.example.schoolquest.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.schoolquest.R
import com.example.schoolquest.databinding.ActivityMainBinding
import com.example.schoolquest.fragments.Tasques_Alumne
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var miMainActivity: MainActivity
    }

    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
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

        binding.navigationView.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menuPerfil -> {

                    Snackbar.make(
                        binding.root,
                        "menuPerfil",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                R.id.menuTasques -> {

                    Snackbar.make(
                        binding.root,
                        "menuTasques",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                R.id.menuCalendari -> {

                    Snackbar.make(
                        binding.root,
                        "menuCalendari",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                R.id.menuBotigaDeRecompenses -> {

                    Snackbar.make(
                        binding.root,
                        "menuBotigaDeRecompenses",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

                R.id.menuSettings -> {

                    Snackbar.make(
                        binding.root,
                        "menuSettings",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
            binding.drawerLayout.openDrawer(GravityCompat.START)
            true
        }

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView2, Tasques_Alumne())
        transaction.addToBackStack(null)
        transaction.commit()
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
