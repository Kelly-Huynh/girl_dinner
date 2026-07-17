package com.example.girldinner

import com.example.girldinner.data.*
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class SampleRecipesTest {
    @Test
    fun `airfryerChipNachos has id of 1`() {
        assertEquals(1, airfryerChipNachos.id)
    }

    @Test
    fun `burgerRecipe has id of 6`() {
        assertEquals(6, burgerRecipe.id)
    }

    @Test
    fun `allRecipes contains burgerRecipe`() {
        assertTrue(allRecipes.contains(burgerRecipe))
    }

    @Test
    fun `allRecipes can find a recipe by id`() {
        val found = allRecipes.find { it.id == 6 }
        assertEquals("Burgers", found?.title)
    }

    @Test
    fun allRecipesHaveValidData() {
        allRecipes.forEach { recipe ->
            assert(recipe.title.isNotEmpty())
            assert(recipe.ingredients.isNotEmpty())
            assert(recipe.instructions.isNotEmpty())
            assert(recipe.imageRes != 0)
        }
    }

    @Test
    fun `allRecipes start with isFavourite as false`() {
        allRecipes.forEach { recipe ->
            assert(!recipe.isFavourite) {
                "Recipe ${recipe.title} should not be favourited by default"
            }
        }
    }
}