package com.example.vgames.model.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "games")
data class RoomGame (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val image: String,
    val deck: String,
    val description: String,
    val originalReleaseDate: LocalDate,
    val platforms: List<String>
)