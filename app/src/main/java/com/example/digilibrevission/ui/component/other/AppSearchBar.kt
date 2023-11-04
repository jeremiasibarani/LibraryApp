package com.example.digilibrevission.ui.component.other

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.digilibrevission.data.Book

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(
    modifier : Modifier = Modifier,
    onSearch : (String) -> Unit,
    searchResult : List<Book>,
    onSearchQueryChange : (String) -> Unit,
    content : @Composable () -> Unit
){
    var query by remember {
        mutableStateOf("")
    }
    var active by remember{
        mutableStateOf(false)
    }

    SearchBar(
        query = query ,
        onQueryChange = { newQuery ->
            query = newQuery
            onSearchQueryChange(newQuery)
        },
        onSearch = { submittedQuery -> onSearch(submittedQuery) },
        active = active,
        onActiveChange = {active = it},
        placeholder = {
            Text(
                text = "Search for a book"
            )
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            if(query != ""){
                IconButton(onClick = {
                    query = ""
                    active = false
                }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                }
            }
        },
        modifier = modifier,
        shape = MaterialTheme.shapes.small
    ){
        if(searchResult.isNotEmpty()){
            content()
        }
    }
}