package com.example.girldinner.screens

import android.R.attr.contentDescription
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.girldinner.R
import com.example.girldinner.data.*
import com.example.girldinner.model.RecipeEntry
import com.example.girldinner.ui.theme.GirlDinnerTheme

@Composable
fun Recipe(recipe: RecipeEntry, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
//            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                recipe.title,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(10.dp),
                color = Color.Black
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.beef_hamburgers),
                    contentDescription = "beef hamburger image",
                    Modifier
                        .fillMaxWidth(0.4f)
                        .height(200.dp)
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Row {
                        Text(
                            "Cooking Time:",
                            modifier = Modifier.width(130.dp),
                            color = Color.Black
                        )
                        Text(
                            "${recipe.cookTimeMinutes} mins",
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Row {
                        Text(
                            "Servings:",
                            modifier = Modifier.width(130.dp),
                            color = Color.Black
                        )
                        Text(
                            "${recipe.servings}",
                            color = Color.Black
                        )
                    }
                }
            }
            Text(
                "Ingredients",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 10.dp)
            )
            recipe.ingredients.forEach { ingredient ->
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        "•",
                        modifier = Modifier.width(24.dp),
                        color = Color.Black
                    )
                    Text(
                        ingredient,
                        color = Color.Black
                    )
                }

            }
            Text(
                "Instructions",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 10.dp)
            )
            recipe.instructions.forEachIndexed { index, step ->
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        "${index + 1}.",
                        modifier = Modifier.width(24.dp),
                        color = Color.Black
                    )
                    Text(
                        step,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipePreview() {
    GirlDinnerTheme {
        Recipe(burgerRecipe)
    }
}