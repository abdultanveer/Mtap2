package com.abdul.mtap2.model

import android.app.Application
import com.abdul.mtap2.model.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class WordsApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { WordRoomDatabase.getDatabase(this,applicationScope) }
    val repository1 by lazy { WordRepository1(database.wordDao()) }



}