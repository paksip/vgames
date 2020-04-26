package com.example.vgames.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.vgames.model.db.entity.RoomGame

@Database(exportSchema = true, version = 1, entities = [RoomGame::class])
abstract class GameDataBase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}