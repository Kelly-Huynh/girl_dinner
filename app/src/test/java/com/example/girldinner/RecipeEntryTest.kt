package com.example.girldinner

import com.example.girldinner.model.RecipeEntry
import org.junit.Test
import org.junit.Assert.*

class RecipeEntryTest {
    private val recipe = RecipeEntry(
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
    fun `stores the correct id`() {
        assertEquals(23, recipe.id)
    }

    @Test
    fun `creates a RecipeEntry with the correct title`() {
        assertEquals("Burgers", recipe.title)
    }

    @Test
    fun `creates a RecipeEntry with the correct cookTimeMinutes`() {
        assertEquals(20, recipe.cookTimeMinutes)
    }

    @Test
    fun `creates a RecipeEntry with the correct servings`() {
        assertEquals(4, recipe.servings)
    }

    @Test
    fun `stores the correct number of ingredients`() {
        assertEquals(6, recipe.ingredients.size)
    }

    @Test
    fun `stores the correct number of instructions`() {
        assertEquals(6, recipe.instructions.size)
    }
    @Test
    fun `isFavourite defaults to false`() {
        assertEquals(false, recipe.isFavourite)
    }

    @Test
    fun `copying changes the favourite state`() {
        val favourited = recipe.copy(isFavourite = true)
        assertEquals(true, favourited.isFavourite)
    }
}