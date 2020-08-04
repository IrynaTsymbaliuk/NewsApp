package com.tsymbaliuk.tsymbaliuk_israel_it

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)

        bottom_nav_view.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { navController, destination, _ ->
            when (destination.id) {
                R.id.sourceFragment -> {
                    /*ivArrowBack.visibility = View.VISIBLE
                    ivArrowBack.setOnClickListener {
                        onBackPressed()
                    }
                    searchView.visibility = View.INVISIBLE
                    tvTitle.visibility = View.INVISIBLE
                    ivStar.visibility = View.VISIBLE

                    ivMore.visibility = View.VISIBLE*/
                }
                else -> {
                    /*ivArrowBack.visibility = View.INVISIBLE
                    searchView.visibility = View.VISIBLE
                    tvTitle.visibility = View.VISIBLE
                    ivStar.visibility = View.GONE
                    ivMore.visibility = View.GONE*/
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }

}