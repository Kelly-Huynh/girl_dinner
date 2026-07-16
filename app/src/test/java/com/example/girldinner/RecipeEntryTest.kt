package com.example.girldinner

import com.example.girldinner.model.RecipeEntry
import org.junit.Test
import org.junit.Assert.*

class RecipeEntryTest {
    @Test
    fun `stores the correct id`() {
        val recipe = RecipeEntry(
            23,
            "Burgers",
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
        assertEquals(23, recipe.id)
    }

    @Test
    fun `creates a RecipeEntry with the correct title`() {
        val recipe = RecipeEntry(
            1,
            "Burgers",
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
        assertEquals("Burgers", recipe.title)
    }

    @Test
    fun `creates a RecipeEntry with the correct cookTimeMinutes`() {
        val recipe = RecipeEntry(
            1,
            "Burgers",
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
        assertEquals(20, recipe.cookTimeMinutes)
    }

    @Test
    fun `creates a RecipeEntry with the correct servings`() {
        val recipe = RecipeEntry(
            1,
            "Burgers",
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
        assertEquals(4, recipe.servings)
    }

    @Test
    fun `stores the correct number of ingredients`() {
        val recipe = RecipeEntry(
            23,
            "Burgers",
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
        assertEquals(6, recipe.ingredients.size)
    }

    @Test
    fun `stores the correct number of instructions`() {
        val recipe = RecipeEntry(
            23,
            "Burgers",
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
        assertEquals(6, recipe.instructions.size)
    }
}