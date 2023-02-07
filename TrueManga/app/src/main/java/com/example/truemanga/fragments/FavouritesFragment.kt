package com.example.truemanga.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.truemanga.*
import com.example.truemanga.databinding.FragmentFavouritesBinding
import com.example.truemanga.fragments.adapters.CardAdapter

class FavouritesFragment : Fragment(), CoverClickListener {

    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        orderFavourites()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragment = this

        _binding = FragmentFavouritesBinding.inflate(layoutInflater)
        binding.recyclerView.apply{
            layoutManager = GridLayoutManager(activity,2)
            adapter= CardAdapter(favouriteList, fragment)
        }
        return binding.root
    }


    override fun onResume() {
        super.onResume()
        if(favouriteList.isEmpty()){
            Toast.makeText(this.context,"No Favourites Found", Toast.LENGTH_SHORT).show()
        }
        else{
            sortFavourites()
        }

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

    private fun orderFavourites(){
        var sortedList = favouriteList.sortedBy {manga -> manga.title }
        favouriteList = sortedList.toMutableList()
    }

    private fun sortFavourites(){
        var checkedList = favouriteList.distinct()
        favouriteList = checkedList.toMutableList()
    }

   
}