package com.abdul.mtap2.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.abdul.mtap2.data.Word1
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoWord {

    @Query("SELECT * FROM Word1 ORDER BY word ASC")
    fun getAllWords(): Flow<List<Word1>>

    @Insert
    suspend fun insert(word: Word1)

    //INSERT INTO Word1 (word) VALUES ("android");
}