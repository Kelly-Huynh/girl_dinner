package com.example.girldinner.data

import com.example.girldinner.model.RecipeEntry
import com.example.girldinner.R

val burgerRecipe = RecipeEntry(
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

