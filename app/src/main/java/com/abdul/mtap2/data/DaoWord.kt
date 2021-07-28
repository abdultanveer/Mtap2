package com.abdul.mtap2.data

import androidx.room.Dao
import androidx.room.Query

import com.abdul.mtap2.model.Word1

@Dao
interface DaoWord {

    @Query("SELECT * FROM Word1 ORDER BY word ASC")
    fun getAllWords(): List<Word1>
}