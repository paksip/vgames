package com.example.vgames.mock.orm

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.vgames.model.db.entity.RoomGame

@Dao
abstract class MockDao {
    @Query("SELECT * FROM games")
    abstract fun getAll(): List<RoomGame>

    @Query("SELECT * FROM games WHERE id = :id")
    abstract fun getOneById(id: Long): RoomGame

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun create(game: RoomGame)

    @Query("DELETE FROM games")
    abstract fun deleteAll()

    @Query("DELETE FROM games WHERE id = :id")
    abstract fun deleteOneById(id: Long)
}