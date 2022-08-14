package com.test.shared.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.shared.model.room.GitListItem


@Database(entities = [GitListItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun listDao(): GitListDao

    companion object {
        private const val databaseName = "TurtleDatabase"

        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                .fallbackToDestructiveMigrationOnDowngrade().build()
        }


    }
}