package com.example.appfortest.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SuperHeroesListEntity::class], version = 1)
abstract class SuperHeroesDataBase: RoomDatabase(){
    abstract fun getSuperHeroDao():SuperHeroDao
}