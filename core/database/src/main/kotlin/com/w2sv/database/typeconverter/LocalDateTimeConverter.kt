package com.w2sv.database.typeconverter

import androidx.room.TypeConverter
import java.time.LocalDateTime

internal object LocalDateTimeConverter {

    @TypeConverter
    fun toDate(dateString: String): LocalDateTime =
        LocalDateTime.parse(dateString)

    @TypeConverter
    fun toDateString(date: LocalDateTime): String =
        date.toString()
}
