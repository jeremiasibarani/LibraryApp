package com.example.digilibrevission.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.ui.BookViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.digilibrevission.data.Book
import com.example.digilibrevission.data.Result
import com.example.digilibrevission.ui.ViewModelFactory
import com.example.digilibrevission.ui.component.book.BookCard
import com.example.digilibrevission.ui.component.other.ProgressBar

@Composable
fun BookScreen(
    modifier : Modifier = Modifier,
    viewModel : BookViewModel = viewModel(factory = ViewModelFactory())
){
    val context = LocalContext.current
    val data by viewModel.books.collectAsState(initial = Result.Loading)
    when(val state = data){
        is Result.Loading -> ProgressBar(modifier = Modifier.fillMaxSize())
        is Result.Error -> {
            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
        }
        is Result.Success -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp),
                contentAlignment = Alignment.Center
            ){
                BookList(
                    modifier = Modifier.fillMaxSize(),
                    books = state.data
                )
            }
        }
    }


}

@Composable
private fun BookList(
    modifier: Modifier = Modifier,
    books : List<Book>
){
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(vertical = 15.dp)
    ){
        items(books){ book ->
            BookCard(
                modifier = Modifier
                    .fillMaxWidth(),
                book = book
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BookScreenPreview(){
    DigilibRevissionTheme {
//        BookScreen(
//            modifier = Modifier
//                .fillMaxSize()
//        )
    }
}