package com.example.appfortest.database

import com.example.appfortest.apiservice.SuperHeroesService
import com.example.appfortest.model.MyTypeHeroData
import com.example.appfortest.model.changeToMyTypeHeroData
import com.example.appfortest.model.fromJsonToMyDataType
import javax.inject.Inject

class SuperHeroesRepository @Inject constructor(
    private val api: SuperHeroesService,
    private val SuperHeroDao: SuperHeroDao
) {

    suspend fun getAllSuperHeroesFromApi(): List<MyTypeHeroData> {
        val response = api.getHeroes()
        return response.fromJsonToMyDataType()
    }

    suspend fun getAllSuperHeroesFromDataBase(): List<MyTypeHeroData> {
        val response: List<SuperHeroesListEntity> = SuperHeroDao.getAllHeroes()
        return response.map { it.changeToMyTypeHeroData() }
    }

    suspend fun insertSuperHeroes(superHeroes:List<SuperHeroesListEntity>){
        SuperHeroDao.insertAllHeroes(superHeroes)
    }

    suspend fun clearSuperHeroes() {
        SuperHeroDao.deleteAllSuperHeroes()
    }
}
