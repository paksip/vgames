package com.example.vgames.mock.orm

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockRoomModule {
    companion object {
        private const val DB_NAME = "game-db"
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): MockDatabase {
        return Room.databaseBuilder(
            context,
            MockDatabase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideGameDao(mockDatabase: MockDatabase): MockDao = mockDatabase.mockGameDao()
}