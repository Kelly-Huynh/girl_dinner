package com.example.girldinner

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.girldinner.viewmodel.RecipeViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreen_showsTitleAndTagline() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            val viewModel: RecipeViewModel = viewModel()
            com.example.girldinner.screens.Home(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Girl Dinner").assertExists()
        composeTestRule.onNodeWithText("a whole meal, allegedly").assertExists()
    }

    @Test
    fun homeScreen_showsRecipeCards() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            val viewModel: RecipeViewModel = viewModel()
            com.example.girldinner.screens.Home(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithText("The Cheese Board Delusion").assertExists()
    }
}