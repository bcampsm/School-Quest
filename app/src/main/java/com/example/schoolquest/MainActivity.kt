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
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)


        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.openDrawer, R.string.CloseDrawer )
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.perfilMenu -> {

                    Snackbar.make(
                        this.findViewById(android.R.id.content),
                        "perfilMenu",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

                R.id.perfilTasques -> {

                    Snackbar.make(
                        this.findViewById(android.R.id.content),
                        "perfilMenu",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

                R.id.perfilCalendari -> {

                    Snackbar.make(
                        this.findViewById(android.R.id.content),
                        "perfilMenu",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

                R.id.perfilBotigaDeRecompenses -> {

                    Snackbar.make(
                        this.findViewById(android.R.id.content),
                        "perfilMenu",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

                R.id.perfilChat -> {

                    Snackbar.make(
                        this.findViewById(android.R.id.content),
                        "perfilMenu",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }
            }

                drawerLayout.openDrawer(GravityCompat.START)

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



//    fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        if (toogle)
//
//        return super.onOptionsItemSelected(item)
//    }




