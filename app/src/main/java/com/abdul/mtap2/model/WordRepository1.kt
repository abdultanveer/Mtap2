package com.abdul.mtap2.model

import kotlinx.coroutines.flow.Flow

class WordRepository1(private val daoWord: DaoWord) {

    fun insert(word1: Word1) {
        daoWord.insert(word1)

    }

    val allWords: Flow<List<Word1>>  = daoWord.getAllWords()
}

