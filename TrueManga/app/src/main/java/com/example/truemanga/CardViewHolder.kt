package com.example.truemanga

import androidx.recyclerview.widget.RecyclerView
import com.example.truemanga.databinding.FragmentSettingsBinding
import com.example.truemanga.databinding.SiteListItemBinding

class CardViewHolder(
    private val siteListItemBinding: SiteListItemBinding,
    private val clickListener: CoverClickListener
) : RecyclerView.ViewHolder(siteListItemBinding.root)
{
    fun bindManga(manga: Manga){
        siteListItemBinding.cover.setImageResource(manga.cover)
        siteListItemBinding.title.text = manga.title
        siteListItemBinding.author.text = manga.author
        siteListItemBinding.site.text = manga.site

        siteListItemBinding.cardView.setOnClickListener{
            clickListener.onClick(manga)
        }
    }
}