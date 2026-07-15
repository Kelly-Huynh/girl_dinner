package com.example.girldinner.model

data class RecipeEntry(
    val title: String,
    val imageRes: Int,
    val cookTimeMinutes: Int,
    val servings: Int,
    val ingredients: List<String>,
    val instructions: List<String>
)
