package com.example.digilibrevission.ui.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.R
import com.example.digilibrevission.ui.BookViewModel
import com.example.digilibrevission.ui.component.home.BookFactBanner
import com.example.digilibrevission.ui.component.home.HomeScreenBanner
import com.example.digilibrevission.ui.component.home.HomeSearchBar
import com.example.digilibrevission.ui.component.home.NewestBooksList
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.digilibrevission.data.Result
import com.example.digilibrevission.ui.ViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier : Modifier = Modifier,
    viewModel : BookViewModel = viewModel(factory = ViewModelFactory())
){
    val searchResult by viewModel.searchResult.observeAsState(initial = emptyList())
    val coroutineScope = rememberCoroutineScope()
    val data by viewModel.books.collectAsState(initial = Result.Loading)
    Log.i("SearchResult-TAG", "$searchResult")
    Box(
        modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(
                id = R.drawable.digilib_unimed),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {
            HomeSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                onSearch = { query ->  },
                searchResult = searchResult,
                onSearchQueryChange = { newQuery ->
                    coroutineScope.launch {
                        delay(1000)
                        viewModel.searchBook(newQuery)
                    }
                }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                HomeScreenBanner(
                    modifier = Modifier
                        .weight(1f)
                ) {

                }
                BookFactBanner(
                    modifier = Modifier
                        .weight(1f)
                )
                NewestBooksList(
                    modifier = Modifier
                        .weight(1f),
                    bookState = data
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    DigilibRevissionTheme {
        //HomeScreen()
    }
}