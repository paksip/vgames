package com.example.vgames.model.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class RoomGame (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val image: String,
    val deck: String,
    val description: String,
    val originalReleaseDate: String,
    val platforms: String
)