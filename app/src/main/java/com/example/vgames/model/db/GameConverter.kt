package com.example.vgames.model.db

import android.arch.persistence.room.TypeConverter
import java.time.LocalDate

class GameConverter {
    @TypeConverter
    fun stringToDate(input: String?): LocalDate? {
        return if (input == null) null else LocalDate.parse(input)
    }

    @TypeConverter
    fun dateToString(input: LocalDate?): String? {
        return input?.toString()
    }

    @TypeConverter
    fun stringListToString(input: List<String>?): String? {
        return if (input == null || input.isEmpty()) null else input.joinToString()
    }

    @TypeConverter
    fun stringToStringList(input: String?): List<String>? {
        return input?.split(",")?.map { it.trim() }
    }
}