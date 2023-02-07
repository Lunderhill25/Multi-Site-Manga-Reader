package com.example.truemanga

var mangaList = mutableListOf<Manga>()
var favouriteList = mutableListOf<Manga>()

val MANGA_ID_EXTRA = "mangaExtra"

class Manga(
    var cover: Int,
    var author: String,
    var title: String,
    var site: String,
    var description: String,
    var id: Int? = mangaList.size
)

