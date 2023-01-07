package com.route.islamic37sat.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islamic37sat.R
import com.route.islamic37sat.databinding.ActivityHomeBinding
import com.route.islamic37sat.home.hadeth.HadethFragment
import com.route.islamic37sat.home.quran.QuranFragment
import com.route.islamic37sat.home.radio.RadioFragment
import com.route.islamic37sat.home.tasbeh.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.content.homeBottomNav
            .setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_quran -> {
                        showFragment(QuranFragment())
                    }
                    R.id.nav_hadeth -> {
                        showFragment(HadethFragment())
                    }
                    R.id.nav_tasbeh -> {
                        showFragment(TasbehFragment())
                    }
                    R.id.nav_radio -> {
                        showFragment(RadioFragment())
                    }
                }
                return@setOnItemSelectedListener true;
            }
        viewBinding.content.homeBottomNav.selectedItemId = R.id.nav_quran
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}