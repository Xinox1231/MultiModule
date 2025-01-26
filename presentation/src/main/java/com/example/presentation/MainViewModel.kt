package com.example.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.AnimeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: AnimeRepository
): ViewModel() {

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> get() = _liveData

    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    fun load(){
        viewModelScope.launch {
            val pair = repository.loadQuote().second
            _liveData.postValue(pair)
        }
    }
}