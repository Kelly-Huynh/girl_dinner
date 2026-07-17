package com.example.girldinner

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.example.girldinner.screens.Favourites
import com.example.girldinner.viewmodel.RecipeViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavouritesScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController
    private lateinit var viewModel: RecipeViewModel

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        navController = TestNavHostController(context)
        viewModel = RecipeViewModel()
    }

    @Test
    fun favouritesScreen_showsOnlyFavouriteRecipes() {
        viewModel.toggleFavourite(1)

        composeTestRule.setContent {
            Favourites(navController = navController, viewModel = viewModel)
        }
        composeTestRule.onNodeWithText("Airfryer Chip Nachos").assertIsDisplayed()
    }

    @Test
    fun favouritesScreen_emptyState_showsPlayfulText() {
        composeTestRule.setContent {
            Favourites(navController = navController, viewModel = viewModel)
        }
        composeTestRule.onNodeWithText("No girl dinners saved yet... let's find some snacks! 🍇🧀")
            .assertIsDisplayed()
    }
}