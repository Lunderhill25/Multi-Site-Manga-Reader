package com.example.truemanga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.truemanga.databinding.ActivityDetailsBinding
import android.widget.Toast

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mangaID = intent.getIntExtra(MANGA_ID_EXTRA, -1)
        val manga = mangaFromID(mangaID)
        if(manga != null){
            binding.cover.setImageResource(manga.cover)
            binding.title.text = manga.title
            binding.author.text = manga.author
            binding.description.text = manga.description
            binding.site.text = manga.site
            binding.siteButton.text = "Go to "+manga.site

            binding.favouriteButton.setOnClickListener{
                //Toast.makeText(this,"clicked favourites",Toast.LENGTH_SHORT).show()
                if(favouriteList.contains(manga)){
                    Toast.makeText(this,"Removed From Favourites",Toast.LENGTH_SHORT).show()
                    favouriteList.remove(manga)
                }
                else{
                    Toast.makeText(this,"Added To Favourites",Toast.LENGTH_SHORT).show()
                    favouriteList.add(manga)
                }
            }

        }
        binding.siteButton.setOnClickListener{
            Toast.makeText(this,"clicked site button",Toast.LENGTH_SHORT).show()
        }


    }

    private fun mangaFromID(mangaID: Int): Manga?{
        for(manga in mangaList){
            if(manga.id == mangaID){
                return manga
            }
        }
        return null
    }
}