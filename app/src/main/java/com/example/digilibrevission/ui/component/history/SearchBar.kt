package com.example.digilibrevission.ui.component.history

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.digilibrevission.data.Book

import com.example.digilibrevission.ui.component.other.AppSearchBar

@Composable
fun HistorySearchBar(
    modifier : Modifier = Modifier,
    onSearch : (String) -> Unit,
    searchResult : List<Book>,
    onSearchQueryChange : (String) -> Unit
){
    AppSearchBar(
        modifier = modifier,
        onSearch = onSearch,
        searchResult = searchResult,
        onSearchQueryChange = onSearchQueryChange,
        content = {
            HistoryBookList(
                modifier = Modifier
                    .fillMaxWidth(),
                searchResult = searchResult
            )
        }
    )
}

@Composable
private fun HistoryBookList(
    modifier: Modifier = Modifier,
    searchResult : List<Book>
){
    searchResult.forEach { book ->
        HistoryBookItem(
            title = book.title,
            modifier = modifier
        )
    }
}

@Composable
private fun HistoryBookItem(
    modifier: Modifier = Modifier,
    title : String
){
    Text(
        text = title,
        modifier = modifier
            .padding(10.dp)
    )
}