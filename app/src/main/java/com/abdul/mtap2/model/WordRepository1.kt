package com.abdul.mtap2.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class WordRepository1(private val daoWord: DaoWord) {

    @WorkerThread
    suspend fun insert(word1: Word1) {
        daoWord.insert(word1)

    }

    val allWords: Flow<List<Word1>>  = daoWord.getAllWords()
}

