package com.example.truemanga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.truemanga.fragments.FavouritesFragment
import com.example.truemanga.fragments.SettingsFragment
import com.example.truemanga.fragments.SitesFragment
import com.example.truemanga.fragments.adapters.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(SitesFragment(),"")
        adapter.addFragment(FavouritesFragment(),"")
        adapter.addFragment(SettingsFragment(),"")
        viewPager.adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!setIcon(R.drawable.ic_baseline_web_24)
        tabs.getTabAt(1)!!setIcon(R.drawable.ic_baseline_star_24)
        tabs.getTabAt(2)!!setIcon(R.drawable.ic_baseline_settings_24)
    }
}