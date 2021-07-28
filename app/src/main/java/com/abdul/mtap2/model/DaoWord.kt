package com.abdul.mtap2.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoWord {

    @Query("SELECT * FROM Word1 ORDER BY word ASC")
    fun getAllWords(): Flow<List<Word1>>

    @Insert
    fun insert(word: Word1)
}