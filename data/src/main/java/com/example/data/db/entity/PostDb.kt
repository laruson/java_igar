package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
class PostDb(
        @PrimaryKey
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
)