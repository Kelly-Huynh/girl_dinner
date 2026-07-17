package com.example.girldinner.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.girldinner.data.airfryerChipNachos
import com.example.girldinner.data.avocadoHummusToast
import com.example.girldinner.data.burgerRecipe
import com.example.girldinner.data.dumplingSalad
import com.example.girldinner.data.eggAndSpinachPide
import com.example.girldinner.data.tofuEggRiceBowl
import com.example.girldinner.model.RecipeEntry

class RecipeViewModel : ViewModel() {
    val allRecipes = mutableStateListOf(
        airfryerChipNachos,
        dumplingSalad,
        tofuEggRiceBowl,
        eggAndSpinachPide,
        avocadoHummusToast,
        burgerRecipe
    )
    fun toggleFavourite(recipeId: Int) {
        val index = allRecipes.indexOfFirst { it.id == recipeId }
        if (index != -1) {
            val current = allRecipes[index]
            allRecipes[index] = current.copy(isFavourite = !current.isFavourite)
        }
    }
}