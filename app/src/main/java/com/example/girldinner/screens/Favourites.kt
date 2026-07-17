package com.example.girldinner.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.girldinner.Routes
import com.example.girldinner.viewmodel.RecipeViewModel
import com.example.girldinner.components.RecipeCard

@Composable
fun Favourites(navController: NavController, viewModel: RecipeViewModel) {
    val favouriteRecipes = viewModel.allRecipes.filter { it.isFavourite }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Your Girl Dinner Picks",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        if (favouriteRecipes.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "No girl dinners saved yet... let's find some snacks! 🍇🧀",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
            }
        } else {
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
    }
}