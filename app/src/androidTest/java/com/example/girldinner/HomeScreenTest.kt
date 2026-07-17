package com.example.girldinner

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.girldinner.screens.Home
import com.example.girldinner.viewmodel.RecipeViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

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

        composeTestRule.onNodeWithContentDescription("Girl Dinner logo")
            .assertIsDisplayed()
    }

    @Test
    fun homeScreen_showsRecipeCards() {
        composeTestRule.setContent {
            Home(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Airfryer Chip Nachos")
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("Dumpling Salad")
            .assertIsDisplayed()
    }
}