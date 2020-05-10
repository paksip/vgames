package com.example.vgames.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.vgames.model.db.entity.RoomGame

@Database(exportSchema = true, version = 1, entities = [RoomGame::class])
@TypeConverters(GameConverter::class)
abstract class GameDataBase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}