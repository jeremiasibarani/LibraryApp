package com.example.digilibrevission.ui.component.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.digilibrevission.data.Book
import com.example.digilibrevission.ui.component.other.AppSearchBar


@Composable
fun HomeSearchBar(
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
            BookSearchList(
                modifier = Modifier
                    .fillMaxWidth(),
                searchResult = searchResult
            )
        }
    )
}

@Composable
private fun BookSearchList(
    modifier: Modifier = Modifier,
    searchResult : List<Book>
){
    searchResult.forEach { book ->
        BookSearchItem(
            title = book.title,
            modifier = modifier
        )
    }
}

@Composable
private fun BookSearchItem(
    modifier: Modifier = Modifier,
    title : String
){
    Text(
        text = title,
        modifier = modifier
            .padding(10.dp)
    )
}

//@Preview(showBackground = true)
//@Composable
//fun SearchBarPreview(){
//    DigilibRevissionTheme {
//        HomeSearchBar(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//
//        }
//    }
//}