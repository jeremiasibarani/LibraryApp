package com.example.digilibrevission.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.digilibrevission.R
import com.example.digilibrevission.ui.screen.Screens


data class BottomNavigationItem(
    val label : String = "",
    @DrawableRes val icon : Int,
    val route : String = ""
)

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        label = "Home",
        icon = R.drawable.ic_home,
        route = Screens.Home.route
    ),
    BottomNavigationItem(
        label = "Buku",
        icon = R.drawable.ic_book,
        route = Screens.Book.route
    ),
    BottomNavigationItem(
        label = "Riwayat",
        icon = R.drawable.ic_history,
        route = Screens.History.route
    ),
    BottomNavigationItem(
        label = "Denda",
        icon = R.drawable.ic_money,
        route = Screens.Penalty.route
    ),
    BottomNavigationItem(
        label = "Profile",
        icon = R.drawable.ic_person,
        route = Screens.Profile.route
    ),
)

fun NavHostController.singleInstanceNavigationUpToDestinationRoute(route : String, destinationRoute : String){
    this.navigate(route){
        launchSingleTop = true
        popUpTo(destinationRoute)
    }
}

@Composable
fun BottomNav(
    modifier : Modifier = Modifier,
    navController: NavHostController
){

    val backStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar(
        modifier = modifier
    ) {
        bottomNavigationItems.forEach { navigationItem ->
            NavigationBarItem(
                selected = navigationItem.route == backStackEntry?.destination?.route,
                onClick = { navController.singleInstanceNavigationUpToDestinationRoute(navigationItem.route, Screens.Home.route) },
                icon = { Icon(painter = painterResource(id = navigationItem.icon), contentDescription = navigationItem.label) },
                label = { Text(text = navigationItem.label)}
            )
        }
    }
}