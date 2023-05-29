package com.example.spotiandoelspot

import SearchFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_main)
        val boton: BottomNavigationView = findViewById(R.id.bottomNavView)
        supportFragmentManager.beginTransaction().replace(R.id.mainCointainer,HomeFragment()).commit()
        boton.setOnItemSelectedListener {menuItem->
            when(menuItem.itemId){

                R.id.inicio ->{
                    goToFragment(HomeFragment())
                    true
                }
                R.id.buscar->{
                    goToFragment(SearchFragment())
                    true
                }
                R.id.biblioteca ->{
                    goToFragment(LibraryFragment())
                    true
                }
                R.id.premium ->{
                    goToFragment(MusicFragment())
                    true
                }
                else -> false
            }

        }
    }

    fun goToFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.mainCointainer,fragment).commit()
    }
}