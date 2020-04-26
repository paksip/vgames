package com.example.vgames.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.vgames.model.db.entity.RoomGame

@Database(exportSchema = true, version = 1, entities = [RoomGame::class])
@TypeConverters(GameConverter::class)
abstract class GameDataBase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}