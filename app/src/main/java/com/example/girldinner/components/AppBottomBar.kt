package com.example.girldinner.components

import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.girldinner.Routes
import com.example.girldinner.model.BottomNavItem

@Composable
fun AppBottomBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", Routes.Home.route, Icons.Default.Home),
        BottomNavItem("Favourites", Routes.Favourites.route, Icons.Default.Favorite),
        BottomNavItem("Search", Routes.Search.route, Icons.Default.Search)
    )
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar (
        modifier = Modifier.background(Color.Red)
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    if (navController.currentDestination?.route != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
//                    navController.navigate(item.route) {
//                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
//                        launchSingleTop = true
//                        restoreState = true
                    }
                }
            )
        }
    }
}
