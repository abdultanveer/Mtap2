package com.abdul.mtap2.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {


    @PrimaryKey(autoGenerate=true)
    public int uid;

    @ColumnInfo
    public String title;

    public Word(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return title;
    }
}
