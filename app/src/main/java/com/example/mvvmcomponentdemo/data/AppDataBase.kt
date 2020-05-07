package com.example.mvvmcomponentdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.mvvmcomponentdemo.utilities.DATABASE_NAME
import com.example.mvvmcomponentdemo.workers.SeedDatabaseWorker

@Database(entities = [GardenPlanting::class,Plant::class] , version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase :RoomDatabase() {
    abstract fun gardenPlantingDao(): GardenPlantingDao
    abstract fun plantDao(): PlantDao


    companion object{
        @Volatile private var instance: AppDataBase? = null

        fun getInstance(context:Context) :AppDataBase{
            return  instance?:
                    synchronized(this){
                        buildDatabase(context).also { instance =it }
                    }
        }

        private fun buildDatabase(context: Context): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    })
                    .build()
        }
    }
}