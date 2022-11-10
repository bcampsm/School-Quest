package com.example.schoolquest

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.schoolquest.R.style.Theme_SchoolQuest
import com.example.schoolquest.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

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
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (toogle.onOptionsItemSelected(item)){
                return true
            }
            return super.onOptionsItemSelected(item)
        }
    }
