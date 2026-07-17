package com.example.girldinner.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.girldinner.Routes
import com.example.girldinner.components.RecipeCard
import com.example.girldinner.viewmodel.RecipeViewModel

@Composable
fun Search(navController: NavController, viewModel: RecipeViewModel) {
    var query by remember { mutableStateOf("") }
    val filteredRecipes = viewModel.allRecipes.filter {
        it.title.contains(query, ignoreCase = true) ||
                it.ingredients.any { ingredient ->
                    ingredient.contains(
                        query,
                        ignoreCase = true
                    )
                } ||
                it.instructions.any { i -> i.contains(query, ignoreCase = true) }
    }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search recipes") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        if (filteredRecipes.isEmpty() && query.isNotEmpty()) {
            Text(
                text = "No recipes found for \"$query\"",
                modifier = Modifier.padding(top = 16.dp)
            )
        } else {
            LazyColumn {
                items(filteredRecipes) { recipe ->
                    RecipeCard(
                        recipe = recipe,
                        onClick = {
                            navController.navigate(Routes.Recipes.createRoute(recipe.id))
                        },
                        onToggleFavourite = { viewModel.toggleFavourite(recipe.id) }
                    )
                }
            }
        }
    }
}
