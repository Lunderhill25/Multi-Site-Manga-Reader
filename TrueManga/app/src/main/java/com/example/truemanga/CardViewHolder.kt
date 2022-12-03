package com.example.truemanga

import androidx.recyclerview.widget.RecyclerView
import com.example.truemanga.databinding.FragmentSettingsBinding

class CardViewHolder(
    private val cardCellBinding: CardCellBinding
) : RecyclerView.ViewHolder(cardCellBinding.root)
{
    fun bindManga(manga: Manga){
        cardCellBinding.cover.setImageResource(manga.cover)
        cardCellBinding.title.text = manga.title
        cardCellBinding.author.text = manga.author
        cardCellBinding.site.text = manga.site
    }
}