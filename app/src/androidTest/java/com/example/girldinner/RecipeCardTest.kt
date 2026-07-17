package com.example.girldinner

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.girldinner.components.RecipeCard
import com.example.girldinner.ui.theme.GirlDinnerTheme
import com.example.girldinner.model.RecipeEntry
import org.junit.Rule
import org.junit.Test

class RecipeCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    private val baseRecipe = RecipeEntry(
        id = 1,
        title = "Tofu Rice Bowl",
        isFavourite = false,
        imageRes = android.R.drawable.ic_menu_gallery, // Use a standard system icon to avoid build errors
        cookTimeMinutes = 15,
        servings = 1,
        ingredients = listOf("Tofu", "Rice"),
        instructions = listOf("Cook rice", "Add tofu")
    )

    private fun setupRecipeCard(
        recipe: RecipeEntry = baseRecipe,
        onClick: () -> Unit = {},
        onToggleFavourite: () -> Unit = {}
    ) {
        composeTestRule.setContent {
            GirlDinnerTheme {
                RecipeCard(
                    recipe = recipe,
                    onClick = onClick,
                    onToggleFavourite = onToggleFavourite
                )
            }
        }
    }

    @Test
    fun recipeCard_displaysAllDataCorrectly() {
        setupRecipeCard()

        composeTestRule.onNodeWithText(baseRecipe.title).assertIsDisplayed()
        composeTestRule.onNodeWithText("Cooking time: ${baseRecipe.cookTimeMinutes} mins").assertIsDisplayed()
        composeTestRule.onNodeWithText("Servings: ${baseRecipe.servings}").assertIsDisplayed()
    }

    @Test
    fun recipeCard_togglingFavourite_firesCallback() {
        var toggleCalled = false
        setupRecipeCard(onToggleFavourite = { toggleCalled = true })

        composeTestRule.onNodeWithContentDescription("Add to Favourites").performClick()

        assert(toggleCalled) { "The toggle favourite callback was not fired." }
    }

    @Test
    fun recipeCard_onClick_firesCallback() {
        var clickCalled = false
        setupRecipeCard(onClick = { clickCalled = true })

        composeTestRule.onRoot().performClick()

        assert(clickCalled) { "The card click callback was not fired." }
    }

    @Test
    fun recipeCard_whenFavourite_displaysFavouriteIcon() {
        val favouriteRecipe = baseRecipe.copy(isFavourite = true)

        setupRecipeCard(recipe = favouriteRecipe)

        composeTestRule.onNodeWithContentDescription("Remove from Favourites").assertExists()
    }

    @Test
    fun recipeCard_withZeroCookTime_displaysCorrectly() {
        val quickRecipe = baseRecipe.copy(cookTimeMinutes = 0)

        setupRecipeCard(recipe = quickRecipe)

        composeTestRule.onNodeWithText("Cooking time: 0 mins").assertIsDisplayed()
    }
}