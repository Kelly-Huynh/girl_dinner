package com.example.girldinner.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.girldinner.R
import com.example.girldinner.data.allRecipes
import com.example.girldinner.model.RecipeEntry
import androidx.compose.foundation.lazy.items
import com.example.girldinner.Routes

@Composable
fun Home(navController: NavHostController) {
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
        LazyColumn {
            items(allRecipes) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    onClick = {
                        navController.navigate(
                            Routes.Recipes.createRoute(recipe.id)
                        )
                    }

                )
            }
        }
    }
    }

@Composable
fun RecipeCard(
    recipe: RecipeEntry,
    onClick: () -> Unit
) {
    Text(
        text = recipe.title,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}



