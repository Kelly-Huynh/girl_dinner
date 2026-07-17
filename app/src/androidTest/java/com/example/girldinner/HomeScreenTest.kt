package com.example.girldinner

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.example.girldinner.data.allRecipes
import com.example.girldinner.screens.Home
import com.example.girldinner.viewmodel.RecipeViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController
    private lateinit var viewModel: RecipeViewModel

    @Before
    fun setup() {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        viewModel = RecipeViewModel()
    }

//    @Test
//    fun homeScreen_showsTitleAndTagline() {
//        composeTestRule.setContent {
//            Home(navController = navController, viewModel = viewModel)
//        }
//
//        composeTestRule.onNodeWithText("Girl Dinner").assertExists()
//        composeTestRule.onNodeWithText("a whole meal, allegedly").assertExists()
//    }
    @Test
    fun homeScreen_showsLogo() {
        composeTestRule.setContent {
            Home(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithContentDescription("Girl Dinner logo").assertExists()

    }

    @Test
    fun homeScreen_showsRecipeCards() {
        composeTestRule.setContent {
            Home(navController = navController, viewModel = viewModel)
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
                   Home(navController = navController, viewModel = viewModel)
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