package com.example.vgames.mock.orm

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.vgames.model.db.entity.RoomGame

@Database(exportSchema = true, version = 1, entities = [RoomGame::class])
abstract class MockDatabase : RoomDatabase() {
    abstract fun mockGameDao(): MockDao
}