package com.abdul.mtap2.mvvm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.abdul.mtap2.model.Word;

@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDb extends RoomDatabase {
    public abstract WordDao wordDao();

    private static WordRoomDb INSTANCE;


    static WordRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDb.class) {
                if (INSTANCE == null)    {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            WordRoomDb.class, "word_database")
                           // .addCallback(sOnOpenCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }}}
        return INSTANCE;
    }



}
