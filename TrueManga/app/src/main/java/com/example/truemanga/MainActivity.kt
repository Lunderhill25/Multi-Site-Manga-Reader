package com.example.truemanga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.example.truemanga.fragments.FavouritesFragment
import com.example.truemanga.fragments.SettingsFragment
import com.example.truemanga.fragments.SitesFragment
import com.example.truemanga.fragments.adapters.ViewPagerAdapter
import com.google.android.material.switchmaterial.SwitchMaterial

///import kotlinx.android.synthetic.main.<activity_main>.*;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()

    }




    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(SitesFragment(),"")
        adapter.addFragment(FavouritesFragment(),"")
        adapter.addFragment(SettingsFragment(),"")

        val viewPager = findViewById<androidx.viewpager.widget.ViewPager>(R.id.view_pager)
        val tabLayout = findViewById<com.google.android.material.tabs.TabLayout>(R.id.tab_layout)

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_web_24)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_star_24)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_settings_24)



    }



}