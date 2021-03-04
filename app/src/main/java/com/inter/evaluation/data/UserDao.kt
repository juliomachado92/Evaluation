package com.inter.evaluation.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface  UserDao{
    @Query("SELECT * FROM users ORDER BY name")
    fun getUsers(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: String): Flow<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)
}