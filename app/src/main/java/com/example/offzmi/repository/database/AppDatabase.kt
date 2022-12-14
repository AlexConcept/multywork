package com.example.offzmi.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.offzmi.repository.database.dao.UserDao
import com.example.offzmi.repository.database.entity.UserEntity

@Database(entities = [(UserEntity::class)], version = 1 )
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}