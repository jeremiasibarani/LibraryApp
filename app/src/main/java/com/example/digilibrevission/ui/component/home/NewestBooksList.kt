package com.example.digilibrevission.ui.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.R
import com.example.digilibrevission.data.Book
import com.example.digilibrevission.data.Result
import com.example.digilibrevission.ui.component.other.ProgressBar

@Composable
fun NewestBooksList(
    modifier: Modifier = Modifier,
    bookState : Result<List<Book>>
){
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Buku terbaru",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .weight(1f),
                fontWeight = FontWeight.W600
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
            )
        }
        when(bookState){
            is Result.Loading -> ProgressBar(modifier = Modifier.fillMaxSize())
            is Result.Error -> {
                Text(text = "Something went wrong")
            }
            is Result.Success -> {
                BookList(
                    modifier = Modifier
                        .fillMaxWidth(),
                    books = bookState.data
                )
            }
        }
    }
}

@Composable
fun BookList(
    modifier: Modifier = Modifier,
    books : List<Book>
){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ){
        items(books){ book ->
            BookItem(book = book)
        }
    }
}

@Composable
fun BookItem(
    modifier : Modifier = Modifier,
    book : Book
){
    Image(
        painter = painterResource(id = book.cover),
        contentDescription = null,
        modifier = modifier
            .width(120.dp)
            .height(190.dp),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun NewestBookListPreview(){
    DigilibRevissionTheme {
//        NewestBooksList(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 10.dp),
//
//        )
    }
}
