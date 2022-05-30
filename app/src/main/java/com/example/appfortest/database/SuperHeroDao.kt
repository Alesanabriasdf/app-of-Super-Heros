package com.example.appfortest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperHeroDao {

    @Query("SELECT * FROM super_heroes_list_table ORDER BY super_hero_name ASC")
    suspend fun getAllHeroes(): List<SuperHeroesListEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllHeroes(superHeroes: List<SuperHeroesListEntity>)

    @Query("DELETE FROM super_heroes_list_table")
    suspend fun deleteAllSuperHeroes()
}
