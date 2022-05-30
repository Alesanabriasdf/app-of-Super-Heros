package com.example.appfortest.model

import com.example.appfortest.database.SuperHeroesListEntity
import com.example.appfortest.model.datafromjson.GlobalDto
import com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon.Thumbnail

data class MyTypeHeroData(
    val description: String,
    val image: String,
    val superHeroName: String
)

fun GlobalDto.fromJsonToMyDataType(): List<MyTypeHeroData> {
    val listSuperHero: MutableList<MyTypeHeroData> = mutableListOf()
    data.results.forEach {
        val changedThumbnailToString = changeThumbnailToString(it.thumbnail)
        listSuperHero.add(
            MyTypeHeroData(
                description = it.description,
                image = changedThumbnailToString,
                superHeroName = it.name,
            )
        )
    }
    return listSuperHero
}

private fun changeThumbnailToString(thumbnail: Thumbnail): String {
    val changeProtocol = thumbnail.path.split(":")
    return "https:" + changeProtocol[1] + "." + thumbnail.extension
}

fun SuperHeroesListEntity.changeToMyTypeHeroData() =
    MyTypeHeroData(description = description, image = image, superHeroName = superHeroName)

fun MyTypeHeroData.changeToSuperHeroesListEntityTypeData() = SuperHeroesListEntity(
    description = description,
    image = image,
    superHeroName = superHeroName
)
