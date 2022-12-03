package com.example.truemanga


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.truemanga.Manga
import com.example.truemanga.databinding.SiteListItemBinding

class CardAdapter(private val manga: List<Manga>)
    : RecyclerView.Adapter<CardViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = SiteListItemBinding.inflate(from, parent,false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindManga(manga[position])
    }

    override fun getItemCount(): Int = manga.size
}