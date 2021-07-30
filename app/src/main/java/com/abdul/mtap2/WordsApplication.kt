package com.abdul.mtap2

import android.app.Application
import com.abdul.mtap2.data.source.WordRepository1
import com.abdul.mtap2.data.source.local.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class WordsApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { WordRoomDatabase.getDatabase(this,applicationScope) }
    val repository1 by lazy { WordRepository1(database.wordDao()) }



}