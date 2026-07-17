package com.example.girldinner.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.girldinner.model.RecipeEntry
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun RecipeCard(
    recipe: RecipeEntry,
    onClick: () -> Unit,
    onToggleFavourite: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = recipe.imageRes),
                contentDescription = recipe.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                IconToggleButton(
                    checked = recipe.isFavourite,
                    onCheckedChange = { onToggleFavourite() }
                ) {
                    Icon(
                        imageVector = if (recipe.isFavourite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favourite",
                        tint = if (recipe.isFavourite) Color.Red else Color.Gray
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Cooking time: ${recipe.cookTimeMinutes} mins",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Servings: ${recipe.servings}",
                style = MaterialTheme.typography.bodyMedium
                )
        }
    }
}