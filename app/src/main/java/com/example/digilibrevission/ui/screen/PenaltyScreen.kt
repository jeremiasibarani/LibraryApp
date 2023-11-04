package com.example.digilibrevission.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
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
import androidx.lifecycle.ViewModelProvider
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.data.BookPenalty
import com.example.digilibrevission.ui.BookViewModel
import com.example.digilibrevission.ui.component.penalty.PenaltyCard
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.digilibrevission.data.Result
import com.example.digilibrevission.ui.ViewModelFactory
import com.example.digilibrevission.ui.component.other.ProgressBar

@Composable
fun PenaltyScreen(
    modifier : Modifier = Modifier,
    viewModel : BookViewModel = viewModel(factory = ViewModelFactory())
){

    val data by viewModel.penalties.collectAsState(initial = Result.Loading)
    val context = LocalContext.current

    when(val state = data){
        is Result.Loading -> ProgressBar(modifier = modifier.fillMaxSize())
        is Result.Error -> {
            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
        }
        is Result.Success -> {
            PenaltyList(
                modifier = modifier
                    .fillMaxSize(),
                penalties = state.data
            )
        }
    }

}

@Composable
private fun PenaltyList(
    modifier : Modifier = Modifier,
    penalties : List<BookPenalty>
){
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(15.dp)
    ){
        items(penalties){ penalty ->
            PenaltyCard(
                modifier = Modifier
                    .fillMaxWidth(),
                penalty = penalty
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PenaltyScreenPreview(){
    DigilibRevissionTheme {
        PenaltyScreen(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}