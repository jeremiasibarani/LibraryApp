package com.example.digilibrevission.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.digilibrevission.data.BookRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BookViewModel::class.java)){
            return BookViewModel(BookRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}