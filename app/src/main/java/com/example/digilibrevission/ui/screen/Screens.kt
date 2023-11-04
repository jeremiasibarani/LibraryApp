package com.example.digilibrevission.ui.screen

sealed class Screens(val route : String){
    object Home : Screens("home_route")
    object Book : Screens("book_route")
    object History : Screens("history_route")
    object Penalty : Screens("penalty_route")
    object Profile : Screens("profile_route")
}