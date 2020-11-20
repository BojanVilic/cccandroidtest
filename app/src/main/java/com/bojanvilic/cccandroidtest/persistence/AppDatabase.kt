package com.bojanvilic.cccandroidtest.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bojanvilic.cccandroidtest.models.Estimate
import com.bojanvilic.cccandroidtest.models.Person

@Database(entities = [Estimate::class, Person::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    abstract fun estimateDao(): EstimateDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}