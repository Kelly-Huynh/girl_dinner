package com.example.girldinner

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.girldinner.model.RecipeEntry
import com.example.girldinner.screens.Recipe
import org.junit.Rule
import org.junit.Test

class RecipeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val testRecipe = RecipeEntry(
        23,
        "Burgers",
        false,
        R.drawable.beef_hamburgers,
        20,
        4,
        listOf(
            "4 Burger Patties",
            "4 Buns",
            "Lettuce",
            "Tomato slices",
            "Sliced onions",
            "Burger Sauce"
        ),
        listOf(
            "Preheat grill to 200°C.",
            "Add patties onto baking tray to grill for 8 minutes.",
            "Flip patties, add in sliced onions and grill for another 8 minutes.",
            "Meanwhile, toast the cut side of buns lightly.",
            "Spread base of buns with burger sauce.",
            "Layer on lettuce, tomato, hamburger patty, grilled onions, add more sauce and top with lid of bun."
        )
    )

    @Test
    fun displaysRecipeTitle() {
        composeTestRule.setContent {
            Recipe(recipe = testRecipe, onToggleFavourite = {})
        }
        composeTestRule.onNodeWithText("Burgers").assertExists()
    }

    @Test
    fun displaysAllIngredients() {
        composeTestRule.setContent {
            Recipe(recipe = testRecipe, onToggleFavourite = {})
        }
        composeTestRule.onNodeWithText("4 Burger Patties").assertExists()
        composeTestRule.onNodeWithText("4 Buns").assertExists()
        composeTestRule.onNodeWithText("Lettuce").assertExists()
        composeTestRule.onNodeWithText("Tomato slices").assertExists()
        composeTestRule.onNodeWithText("Sliced onions").assertExists()
        composeTestRule.onNodeWithText("Burger Sauce").assertExists()
    }

    @Test
    fun displaysAllInstructions() {
        composeTestRule.setContent {
            Recipe(recipe = testRecipe, onToggleFavourite = {})
        }
        composeTestRule.onNodeWithText("Preheat grill to 200°C.").assertExists()
        composeTestRule.onNodeWithText("Add patties onto baking tray to grill for 8 minutes.").assertExists()
        composeTestRule.onNodeWithText("Flip patties, add in sliced onions and grill for another 8 minutes.").assertExists()
        composeTestRule.onNodeWithText("Meanwhile, toast the cut side of buns lightly.").assertExists()
        composeTestRule.onNodeWithText("Spread base of buns with burger sauce.").assertExists()
        composeTestRule.onNodeWithText("Layer on lettuce, tomato, hamburger patty, grilled onions, add more sauce and top with lid of bun.").assertExists()
    }

    @Test
    fun tappingFavouriteIcon_firesCallback() {
        var toggleCalled = false
        composeTestRule.setContent {
            Recipe(recipe = testRecipe, onToggleFavourite = { toggleCalled = true })
        }

        composeTestRule.onNodeWithContentDescription("Favourite").performClick()

        assert(toggleCalled) { "onToggleFavourite was not called when tapping the heart icon." }
    }
}