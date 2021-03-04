package com.inter.evaluation.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "users")
data class User(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    val name: String,
    val username: String,
    val email: String,
    val phone: String
) {

    override fun toString() = name

    fun getLetra() = name.substring(0,2).toUpperCase()
}