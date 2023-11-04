package com.example.digilibrevission

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.ui.component.BottomNav
import com.example.digilibrevission.ui.screen.BookScreen
import com.example.digilibrevission.ui.screen.HistoryBookScreen
import com.example.digilibrevission.ui.screen.HomeScreen
import com.example.digilibrevission.ui.screen.PenaltyScreen
import com.example.digilibrevission.ui.screen.ProfileScreen
import com.example.digilibrevission.ui.screen.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookApp()
        }
    }
}

@Composable
fun BookApp(){
    val navController = rememberNavController()

    DigilibRevissionTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            bottomBar = {
                BottomNav(
                    navController = navController
                )
            }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Screens.Home.route,
                modifier = Modifier
                    .padding(paddingValues)
            ){
                composable(Screens.Home.route){
                    HomeScreen()
                }
                composable(Screens.Book.route){
                    BookScreen()
                }
                composable(Screens.History.route){
                    HistoryBookScreen()
                }
                composable(Screens.Penalty.route){
                    PenaltyScreen()
                }
                composable(Screens.Profile.route){
                    ProfileScreen()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookApp()
}