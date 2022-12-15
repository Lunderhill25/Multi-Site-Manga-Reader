package com.example.truemanga.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.truemanga.*
import com.example.truemanga.databinding.FragmentSitesBinding


class SitesFragment : Fragment(), CoverClickListener {

    private var _binding: FragmentSitesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gatherManga()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val fragment = this

        _binding = FragmentSitesBinding.inflate(layoutInflater)
        binding.recyclerView.apply{
                layoutManager = GridLayoutManager(activity,2)
                adapter= CardAdapter(mangaList)
        }
        return binding.root

    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    //Currently hardcoded for testing
    private fun gatherManga(){
        val manga1 = Manga(
            R.drawable.sololevelingcover,
            "Chu-Gong",
            "Solo-Leveling",
            "placeholder",
            "In a world where hunters, humans who possess magical abilities, must battle deadly monsters to protect mankind from certain annihilation, a notoriously weak hunter named Sung Jinwoo finds himself in a seemingly endless struggle for survival. One day, after narrowly surviving an overwhelmingly powerful dungeon that nearly wipes out his entire party, a mysterious program called the System chooses him as its sole player and in turn, gives him the extremely rare ability to level up in strength, possibly beyond any known limits. Follow Jinwoo's journey as he fights against all kinds of enemies, both man and monster, to discover the secrets of the dungeons and the true source of his powers."
        )
        mangaList.add(manga1)
        val manga2 = Manga(
            R.drawable.berserkcover,
            "Kentaro Miura",
            "Berserk",
            "placeholder",
            "no synopsis"
        )
        mangaList.add(manga2)
        val manga3 = Manga(
            R.drawable.chainsawmancover,
            "Tatsuki Fujimoto",
            "Chainsaw Man",
            "placeholder",
            "Following a betrayal, a young man left for the dead is reborn as a powerful devil-human hybrid after merging with his pet devil and is soon enlisted into an organization dedicated to hunting devils."
        )
        mangaList.add(manga3)

    }

    override fun onClick(manga: Manga) {
        //val intent = Intent
    }

}