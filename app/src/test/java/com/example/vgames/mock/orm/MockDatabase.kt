package com.example.vgames.mock.orm

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vgames.model.db.entity.RoomGame

@Database(exportSchema = true, version = 1, entities = [RoomGame::class])
abstract class MockDatabase : RoomDatabase() {
    abstract fun mockGameDao(): MockDao
}