package com.abdul.mtap2.model

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class WordViewModel1(private val repository: WordRepository1): ViewModel() {

    val allWords: LiveData<List<Word1>> = repository.allWords.asLiveData()

    fun insert(word1: Word1) = viewModelScope.launch {
        repository.insert(word1)
    }
}
class WordViewModelFactory(private val repository: WordRepository1): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel1::class.java)){
            return WordViewModel1(repository) as T
        }
        throw IllegalArgumentException("unknow viewmodel")
    }
}