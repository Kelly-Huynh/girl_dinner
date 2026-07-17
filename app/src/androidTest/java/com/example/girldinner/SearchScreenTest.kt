package com.example.girldinner

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.example.girldinner.screens.Search
import com.example.girldinner.viewmodel.RecipeViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class SearchScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController
    private lateinit var viewModel: RecipeViewModel

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        navController = TestNavHostController(context)
        viewModel = RecipeViewModel()

        composeTestRule.setContent {
            Search(navController = navController, viewModel = viewModel)
        }
    }

    @Test
    fun searchScreen_typingQuery_filtersResults() {
        composeTestRule.onNodeWithText("Search recipes")
            .performTextInput("Nachos")

        composeTestRule.onNodeWithText("Airfryer Chip Nachos").assertIsDisplayed()
        composeTestRule.onNodeWithText("Dumpling Salad").assertDoesNotExist()
        composeTestRule.onNodeWithText("Tofu Egg Rice Bowl").assertDoesNotExist()
        composeTestRule.onNodeWithText("Egg and spinach pide").assertDoesNotExist()
        composeTestRule.onNodeWithText("Avocado and hummus toast").assertDoesNotExist()
        composeTestRule.onNodeWithText("Burgers").assertDoesNotExist()
    }

    @Test
    fun searchScreen_searchingForIngredient_showsMatchingRecipe() {
        composeTestRule.onNodeWithText("Search recipes").performTextInput("kidney beans")
        composeTestRule.onNodeWithText("Airfryer Chip Nachos").assertIsDisplayed()
    }

    @Test
    fun searchScreen_noResults_showsEmptyPlaceholder() {
        composeTestRule.onNodeWithText("Search recipes")
            .performTextInput("NonExistentRecipeName")

        composeTestRule.onNodeWithText("No recipes found for \"NonExistentRecipeName\"")
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("Airfryer Chip Nachos")
            .assertDoesNotExist()
    }
}