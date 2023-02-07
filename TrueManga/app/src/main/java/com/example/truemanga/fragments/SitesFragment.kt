package com.example.truemanga.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.truemanga.*
import com.example.truemanga.databinding.FragmentSitesBinding
import com.example.truemanga.fragments.adapters.CardAdapter


class SitesFragment : Fragment(), CoverClickListener {

    private var _binding: FragmentSitesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(mangaList.isEmpty()){gatherManga()}

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragment = this

        _binding = FragmentSitesBinding.inflate(layoutInflater)
        binding.recyclerView.apply{
                layoutManager = GridLayoutManager(activity,2)
                adapter= CardAdapter(mangaList, fragment)
        }
        return binding.root

    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(manga: Manga) {
        val intent = android.content.Intent(activity, DetailsActivity::class.java)
        intent.putExtra(MANGA_ID_EXTRA, manga.id)
        startActivity(intent)

    }

    //Currently hardcoded for testing
    private fun gatherManga(){
        val manga1 = Manga(
            R.drawable.berserkcover,
            "Kentaro Miura",
            "Berserk",
            "placeholder",
            "no synopsis"
        )
        mangaList.add(manga1)
        val manga2 = Manga(
            R.drawable.chainsawmancover,
            "Tatsuki Fujimoto",
            "Chainsaw Man",
            "placeholder",
            "Following a betrayal, a young man left for the dead is reborn as a powerful devil-human hybrid after merging with his pet devil and is soon enlisted into an organization dedicated to hunting devils."
        )
        mangaList.add(manga2)
        val manga3 = Manga(
            R.drawable.sololevelingcover,
            "Chu-Gong",
            "Solo-Leveling",
            "placeholder",
            "In a world where hunters, humans who possess magical abilities, must battle deadly monsters to protect mankind from certain annihilation, a notoriously weak hunter named Sung Jinwoo finds himself in a seemingly endless struggle for survival. One day, after narrowly surviving an overwhelmingly powerful dungeon that nearly wipes out his entire party, a mysterious program called the System chooses him as its sole player and in turn, gives him the extremely rare ability to level up in strength, possibly beyond any known limits. Follow Jinwoo's journey as he fights against all kinds of enemies, both man and monster, to discover the secrets of the dungeons and the true source of his powers."
        )
        mangaList.add(manga3)
        val manga4 = Manga(
            R.drawable.reincarnatedasaslimecover,
            "Fuse",
            "That time I was reincarnated as a slime",
            "placeholder",
            "Corporate worker Mikami Satoru is stabbed by a random killer, and is reborn to an alternate world. But he turns out to be reborn a slime. Thrown into this new world with the name Rimuru, he begins his quest to create a world that's welcoming to all races."
        )
        mangaList.add(manga4)
        val manga5 = Manga(
            R.drawable.yuanzuncover,
            "Heavenly Silkworm Potato",
            "Yuan Zun",
            "placeholder",
            "A young man with his brush plunges into a chaotic world and lights up the heavens. In a world where cultivators are paramount, will the vermilion bird swallow the dragon, or will the dragon transcend beyond all else?!"
        )
        mangaList.add(manga5)
        orderManga()

    }

    private fun orderManga(){
        var temp = mutableListOf<Manga>()
        var sortedList = mangaList.sortedBy {manga -> manga.title }
        mangaList = sortedList.toMutableList()
    }



}