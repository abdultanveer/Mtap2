package com.abdul.mtap2.data.source

import androidx.annotation.WorkerThread
import com.abdul.mtap2.data.Word1
import com.abdul.mtap2.data.source.local.DaoWord
import kotlinx.coroutines.flow.Flow

class WordRepository1(private val daoWord: DaoWord) {

    @WorkerThread
    suspend fun insert(word1: Word1) {
        daoWord.insert(word1)

    }

    val allWords: Flow<List<Word1>>  = daoWord.getAllWords()  //Flowable
}

