package com.abdul.mtap2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abdul.mtap2.model.Word1

@Database(entities = [Word1::class], version = 1)
abstract class WordRoomDatabase: RoomDatabase() {
    abstract fun daoWord(): DaoWord

    companion object{
        private var INSTANCE: WordRoomDatabase? = null

        /*fun getDatabase(context: Context): WordRoomDatabase {
            return  INSTANCE?: (this){
                val instance = Room.databaseBuilder(
                    context,WordRoomDatabase::class.java,
                    "wordsdb")
                    .fallbackToDestructiveMigration()
                    .addCallback()
                    .build();
            }
        }*/
        private class WordDbCallback()
    }
}