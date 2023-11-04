package com.example.digilibrevission.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.data.Book
import com.example.digilibrevission.data.Result
import com.example.digilibrevission.ui.BookViewModel
import com.example.digilibrevission.ui.ViewModelFactory
import com.example.digilibrevission.ui.component.history.HistoryCard
import com.example.digilibrevission.ui.component.history.HistorySearchBar
import com.example.digilibrevission.ui.component.other.ProgressBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HistoryBookScreen(
    modifier : Modifier = Modifier,
    viewModel: BookViewModel = viewModel(factory = ViewModelFactory())
){
    val data by viewModel.history.collectAsState(initial = Result.Loading)
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val searchResult by viewModel.searchHistoryResult.observeAsState(initial = emptyList())
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp)
    ) {
        HistorySearchBar(
            onSearch = {query -> },
            searchResult = searchResult,
            onSearchQueryChange = {newQuery ->
                coroutineScope.launch {
                    delay(1000)
                    viewModel.searchHistory(newQuery)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
        )
        when(val state = data){
            is Result.Loading -> ProgressBar(
                modifier = Modifier
                    .fillMaxSize()
            )
            is Result.Error -> {
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            is Result.Success -> {
                HistoryBookList(
                    modifier = Modifier
                        .weight(1f),
                    histories = state.data
                )
            }
        }
    }
}

@Composable
private fun HistoryBookList(
    modifier : Modifier = Modifier,
    histories : List<Book>
){
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(vertical = 15.dp)
    ){
        items(histories){ book ->
            HistoryCard(
                modifier = Modifier
                    .fillMaxWidth(),
                book = book
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryBookScreenPreview(){
    DigilibRevissionTheme {
//        HistoryBookScreen(
//            modifier = Modifier
//                .fillMaxSize()
//        )
    }
}