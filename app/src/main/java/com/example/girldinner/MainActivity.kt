package com.example.girldinner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.girldinner.ui.theme.GirlDinnerTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.girldinner.components.AppBottomBar
import com.example.girldinner.screens.Home
import com.example.girldinner.data.allRecipes
import com.example.girldinner.screens.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.girldinner.viewmodel.RecipeViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GirlDinnerTheme {
                val viewModel: RecipeViewModel = viewModel()
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                    bottomBar = {
                        Surface(color = Color.Red) {
                            AppBottomBar(navController = navController) }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding))
                    {
                        ScreenMain(
                            navController = navController,
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ScreenMain(navController: NavHostController, viewModel: RecipeViewModel, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = Routes.Home.route, modifier = modifier) {
        composable(Routes.Home.route) {
            Home(navController = navController, viewModel = viewModel)
        }
        composable(Routes.Recipes.route) { backStackEntry ->

            val recipeId =
                backStackEntry.arguments?.getString("recipeId")?.toInt() ?: 1

            val recipe = viewModel.allRecipes.first { it.id == recipeId }

            Recipe(
                recipe = recipe,
                onToggleFavourite = { viewModel.toggleFavourite(recipe.id) }
            )
        }
        composable(Routes.Favourites.route) {
            Favourites(navController = navController, viewModel = viewModel)
        }
        composable(Routes.Search.route) {
            Search(navController = navController, viewModel = viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenMainPreview() {
    GirlDinnerTheme {
        val mockNavController = rememberNavController()
        val viewModel: RecipeViewModel = viewModel()
        ScreenMain(navController = mockNavController, viewModel = viewModel)
    }
}



