package com.example.girldinner

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.girldinner.data.allRecipes
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreen_showsLogo() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            com.example.girldinner.screens.Home(navController = navController)
        }

        composeTestRule.onNodeWithContentDescription("Girl Dinner logo").assertExists()
    }

    @Test
    fun homeScreen_showsRecipeCards() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            com.example.girldinner.screens.Home(navController = navController)
        }

        // Checks every recipe title renders on screen.
        allRecipes.forEach { recipe ->
            composeTestRule.onNodeWithText(recipe.title).assertExists()
        }
    }

    @Test
    fun homeScreen_clickingRecipe_navigatesToRecipeRoute() {
        lateinit var navController: TestNavHostController
        val firstRecipe = allRecipes.first()

        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())

            NavHost(navController = navController, startDestination = Routes.Home.route) {
                composable(Routes.Home.route) {
                    com.example.girldinner.screens.Home(navController = navController)
                }
                // Dummy destination — just confirms navigation reaches it.
                composable(Routes.Recipes.route) { }
            }
        }

        composeTestRule.onNodeWithText(firstRecipe.title).performClick()

        val currentRoute = navController.currentBackStackEntry?.destination?.route
        assertEquals(Routes.Recipes.route, currentRoute)

        val recipeIdArg = navController.currentBackStackEntry?.arguments?.getString("recipeId")
        assertEquals(firstRecipe.id.toString(), recipeIdArg)
    }
}