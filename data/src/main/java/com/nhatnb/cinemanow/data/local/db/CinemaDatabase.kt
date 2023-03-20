package com.nhatnb.cinemanow.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nhatnb.cinemanow.data.local.dao.MovieDao
import com.nhatnb.cinemanow.data.local.entity.MovieDbEntity

@Database(entities = [MovieDbEntity::class], version = 1)
abstract class CinemaDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        private var instance: CinemaDatabase? = null

        fun getInstance(context: Context): CinemaDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    CinemaDatabase::class.java,
                    "cinema_db"
                ).build().also {
                    instance = it
                }
            }
        }
    }
}