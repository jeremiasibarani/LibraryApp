package com.example.digilibrevission.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.digilibrevission.data.Book
import com.example.digilibrevission.data.BookPenalty
import com.example.digilibrevission.data.BookRepository
import com.example.digilibrevission.data.Result
import kotlinx.coroutines.flow.Flow

class BookViewModel(private val repository: BookRepository) : ViewModel() {

    val books : Flow<Result<List<Book>>> = repository.getBooks()
    val history : Flow<Result<List<Book>>> = repository.getHistoryBooks()
    val penalties : Flow<Result<List<BookPenalty>>> = repository.getPenalties()

    private val _query = MutableLiveData<String>()
    val searchResult : LiveData<List<Book>> = _query.switchMap { title ->
        repository.searchBook(title)
    }

    fun searchBook(title : String) {
        _query.value = title
        Log.i("SearhQuery-TAG", title)
        Log.i("SearhQuery-TAG", "${_query.value}")
    }

    private val _queryHistory = MutableLiveData<String>()
    val searchHistoryResult : LiveData<List<Book>> = _queryHistory.switchMap { title ->
        repository.searchHistoryBook(title)
    }

    fun searchHistory(query : String) {
        _queryHistory.value = query
        Log.i("SearhQuery-TAG", query)
        Log.i("SearhQuery-TAG", "${_query.value}")
    }

    private val _queryPenalties = MutableLiveData<String>()
    val searchPenaltiesResult : LiveData<List<BookPenalty>> = _queryPenalties.switchMap { title ->
        repository.searchPenalties(title)
    }

    fun searchPenalties(query : String) {
        _queryPenalties.value = query
        Log.i("SearhQuery-TAG", query)
        Log.i("SearhQuery-TAG", "${_query.value}")
    }

}