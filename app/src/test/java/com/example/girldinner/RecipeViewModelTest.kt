package com.example.girldinner

import com.example.girldinner.viewmodel.RecipeViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class RecipeViewModelTest {
    private lateinit var viewModel: RecipeViewModel

    @Before
    fun setup() {
        viewModel = RecipeViewModel()
    }

    @Test
    fun `initialization loads all recipes correctly`() {
        val expectedSize = 6
        assertEquals("The initial recipe list size should match the data source.", expectedSize, viewModel.allRecipes.size)
    }

    @Test
    fun `toggleFavourite successfully updates the specific recipe state`() {

        val targetRecipe = viewModel.allRecipes.first()
        val originalStatus = targetRecipe.isFavourite
        val targetId = targetRecipe.id

        viewModel.toggleFavourite(targetId)

        val updatedRecipe = viewModel.allRecipes.find { it.id == targetId }

        assertEquals(!originalStatus, updatedRecipe?.isFavourite)
    }

    @Test
    fun `toggleFavourite does not impact other recipes`() {
        val idToToggle = viewModel.allRecipes.first().id
        val otherRecipeId = viewModel.allRecipes.last().id

        val otherRecipeOriginalStatus = viewModel.allRecipes.last().isFavourite

        viewModel.toggleFavourite(idToToggle)

        val otherRecipeAfter = viewModel.allRecipes.find { it.id == otherRecipeId }
        assertEquals(otherRecipeOriginalStatus, otherRecipeAfter?.isFavourite)
    }

    @Test
    fun `toggleFavourite with invalid ID does not mutate list`() {
        val initialState = viewModel.allRecipes.toList()

        viewModel.toggleFavourite(-999)

        assertEquals("The list should remain identical when an invalid ID is provided.", initialState, viewModel.allRecipes.toList())
    }
}