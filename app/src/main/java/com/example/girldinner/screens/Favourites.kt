package com.example.girldinner.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.girldinner.Routes
import com.example.girldinner.viewmodel.RecipeViewModel
import com.example.girldinner.components.RecipeCard

@Composable
fun Favourites(navController: NavController, viewModel: RecipeViewModel) {
    val favouriteRecipes = viewModel.allRecipes.filter { it.isFavourite }

    LazyColumn {
        items(favouriteRecipes) { recipe ->
            RecipeCard(
                recipe = recipe,
                onClick = { navController.navigate(Routes.Recipes.createRoute(recipe.id)) },
                onToggleFavourite = { viewModel.toggleFavourite(recipe.id) }
            )
        }
    }
}