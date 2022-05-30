package com.example.appfortest.viewmodel

import com.example.appfortest.database.SuperHeroesRepository
import com.example.appfortest.model.MyTypeHeroData
import com.example.appfortest.model.changeToSuperHeroesListEntityTypeData
import javax.inject.Inject

class GetAllHeroes @Inject constructor(private val repository: SuperHeroesRepository) {

    suspend operator fun invoke(): List<MyTypeHeroData> {
        val superHeroes = repository.getAllSuperHeroesFromApi()
        if (superHeroes.isNotEmpty()) {
            repository.clearSuperHeroes()
            repository.insertSuperHeroes(superHeroes.map { it.changeToSuperHeroesListEntityTypeData() })
            return repository.getAllSuperHeroesFromDataBase()
        }else {
            return emptyList()
        }
    }
}