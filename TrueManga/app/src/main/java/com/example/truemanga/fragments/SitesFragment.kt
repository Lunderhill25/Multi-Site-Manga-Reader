package com.example.truemanga.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.truemanga.CardAdapter
import com.example.truemanga.Manga
import com.example.truemanga.R
import com.example.truemanga.databinding.ActivityMainBinding
import com.example.truemanga.mangaList


class SitesFragment : Fragment() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gatherManga()

        val mainActivity = this
        binding.recyclerView.apply{
            layoutManager = GridLayoutManager(applicationContext,3)
            adapter= CardAdapter(mangaList)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sites, container, false)
    }

    //Currently hardcoded for testing
    private fun gatherManga(){
        val manga1 = Manga(
            R.drawable.slc,
            "Chu-Gong",
            "Solo-Leveling",
            "Webnovel.com",
            "In a world where hunters, humans who possess magical abilities, must battle deadly monsters to protect mankind from certain annihilation, a notoriously weak hunter named Sung Jinwoo finds himself in a seemingly endless struggle for survival. One day, after narrowly surviving an overwhelmingly powerful dungeon that nearly wipes out his entire party, a mysterious program called the System chooses him as its sole player and in turn, gives him the extremely rare ability to level up in strength, possibly beyond any known limits. Follow Jinwoo's journey as he fights against all kinds of enemies, both man and monster, to discover the secrets of the dungeons and the true source of his powers."
        )
        mangaList.add(manga1)

    }

}