package com.example.girldinner.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.girldinner.R
import com.example.girldinner.Routes
import com.example.girldinner.model.RecipeEntry
import com.example.girldinner.ui.theme.GirlDinnerTheme
import com.example.girldinner.components.*
import com.example.girldinner.viewmodel.RecipeViewModel

@Composable
fun Home(navController: NavHostController, viewModel: RecipeViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Girl Dinner logo",
            modifier = Modifier
                .clip(CircleShape)
                .graphicsLayer(
                    scaleX = 1.3f,
                    scaleY = 1.3f
                ),
            contentScale = ContentScale.Crop
        )
        LazyColumn (
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(viewModel.allRecipes) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    onClick = {
                        navController.navigate(
                            Routes.Recipes.createRoute(recipe.id)
                        )
                    },
                    onToggleFavourite = { viewModel.toggleFavourite(recipe.id) }

                )
            }
        }
    }
    }

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    GirlDinnerTheme {
        val mockNavController = rememberNavController()
        val viewModel: RecipeViewModel = viewModel()
        Home(navController = mockNavController, viewModel = viewModel)
    }
}


