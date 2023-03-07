package com.sohail.simplecontactstore.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sohail.simplecontactstore.database.dao.NameDao
import com.sohail.simplecontactstore.database.model.Name

@Database(entities = [Name::class], version = 1, exportSchema = false)
abstract class NameDatabase : RoomDatabase() {
    abstract fun getNameDao() : NameDao

    companion object{
        private const val DATABASE_NAME = "names_db"

        @Volatile
        private var INSTANCE : NameDatabase? = null

        fun getDatabase(context: Context) : NameDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    NameDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}