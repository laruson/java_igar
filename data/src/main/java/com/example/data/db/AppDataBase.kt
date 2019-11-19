package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.db.dao.PostDao
import com.example.data.db.entity.PostDb

@Database(entities = [PostDb::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "tweetDb"

        fun getInstance(context: Context): AppDataBase {

            return Room
                    .databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration() //если версии отличаются текущую удалит и создает новую
                    .build()
        }
    }

    abstract fun postDao() : PostDao
}