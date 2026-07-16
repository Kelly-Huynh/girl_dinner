package com.example.girldinner

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Recipes : Routes("recipes")
}