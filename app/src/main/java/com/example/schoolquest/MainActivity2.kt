package com.example.schoolquest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.schoolquest.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toogle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.openDrawer, R.string.CloseDrawer )
        binding.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navigationView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.menuPerfil2 -> {

                    Snackbar.make(
                        binding.root,
                        "menuPerfil",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                R.id.menuTasques2 -> {

                    Snackbar.make(
                        binding.root,
                        "menuTasques",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                R.id.menuCalendari2 -> {

                    Snackbar.make(
                        binding.root,
                        "menuCalendari",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                R.id.menuBotigaDeRecompenses2 -> {

                    Snackbar.make(
                        binding.root,
                        "menuBotigaDeRecompenses",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

                R.id.menuSettings2 -> {

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
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}