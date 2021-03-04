package com.inter.evaluation.data

import androidx.room.Embedded
import androidx.room.Relation

data class Users(
    @Embedded
    val user: User,

    @Relation(parentColumn = "id", entityColumn = "id")
    val Users: List<User> = emptyList()
)