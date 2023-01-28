package com.example.multywork.repository.database.dao

import androidx.room.*
import com.example.multywork.repository.database.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getById(id: Int): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(userEntity: List<UserEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(userEntity: UserEntity)

    @Update
    fun updateAll(list:List<UserEntity>)

    @Delete
    fun delete(userEntity: UserEntity)
}