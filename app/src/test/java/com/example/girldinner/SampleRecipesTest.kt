package com.example.girldinner

import com.example.girldinner.data.*
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class SampleRecipesTest {
    @Test
    fun `burgerRecipe has id of 1`() {
        assertEquals(1, burgerRecipe.id)
    }

    @Test
    fun `allRecipes contains burgerRecipe`() {
        assertTrue(allRecipes.contains(burgerRecipe))
    }

    @Test
    fun `allRecipes can find a recipe by id`() {
        val found = allRecipes.find { it.id == 1 }
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
}