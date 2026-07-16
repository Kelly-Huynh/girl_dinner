package com.example.girldinner

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
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
            com.example.girldinner.screens.Home(navController = navController)
        }

        composeTestRule.onNodeWithText("Girl Dinner").assertExists()
        composeTestRule.onNodeWithText("a whole meal, allegedly").assertExists()
    }

    @Test
    fun homeScreen_showsRecipeCards() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            com.example.girldinner.screens.Home(navController = navController)
        }

        composeTestRule.onNodeWithText("The Cheese Board Delusion").assertExists()
    }
}