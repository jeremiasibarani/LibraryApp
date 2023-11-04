package com.example.digilibrevission.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BookRepository {

    fun getBooks() : Flow<Result<List<Book>>> = flow {
        emit(Result.Loading)
        try{
            val data = DataSource.getBooks()
            emit(Result.Success(data))
        }catch (ex : Exception){
            emit(Result.Error(ex.message.toString()))
        }
    }

    fun searchBook(query : String) : LiveData<List<Book>> = liveData {
        emit(DataSource.searchBook(query))
    }

    fun getHistoryBooks() : Flow<Result<List<Book>>> = flow {
        emit(Result.Loading)
        try{
            val data = DataSource.getHistoryBooks()
            emit(Result.Success(data))
        }catch (ex : Exception){
            emit(Result.Error(ex.message.toString()))
        }
    }

    fun searchHistoryBook(query : String) : LiveData<List<Book>> = liveData {
        emit(DataSource.searchHistory(query))
    }

    fun getPenalties() : Flow<Result<List<BookPenalty>>> = flow {
        emit(Result.Loading)
        try{
            val data = DataSource.getPenalties()
            emit(Result.Success(data))
        }catch (ex : Exception){
            emit(Result.Error(ex.message.toString()))
        }
    }

    fun searchPenalties(query : String) : LiveData<List<BookPenalty>> = liveData {
        emit(DataSource.searchPenalties(query))
    }

}