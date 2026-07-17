package com.example.girldinner

import android.content.Context
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.example.girldinner.components.AppBottomBar
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AppBottomBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun setupBottomBar(startRoute: String): TestNavHostController {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val navController = TestNavHostController(context)

        composeTestRule.setContent {
            navController.apply {
                navigatorProvider.addNavigator(ComposeNavigator())
                graph = createGraph(startDestination = startRoute) {
                    composable(Routes.Home.route) {}
                    composable(Routes.Favourites.route) {}
                    composable(Routes.Search.route) {}
                }
            }
            AppBottomBar(navController = navController)
        }
        return navController
    }

    @Test
    fun appBottomBar_navigatesToHome() {
        val navController = setupBottomBar(Routes.Favourites.route)

        composeTestRule.onNodeWithContentDescription("Home", useUnmergedTree = true)
            .performClick()

        assertEquals(Routes.Home.route, navController.currentBackStackEntry?.destination?.route)
    }

    @Test
    fun appBottomBar_navigatesToFavourites() {
        val navController = setupBottomBar(Routes.Home.route)

        composeTestRule.onNodeWithContentDescription("Favourites", useUnmergedTree = true)
            .performClick()

        assertEquals(Routes.Favourites.route, navController.currentBackStackEntry?.destination?.route)
    }

    @Test
    fun appBottomBar_navigatesToSearch() {
        val navController = setupBottomBar(Routes.Home.route)

        composeTestRule.onNodeWithContentDescription("Search", useUnmergedTree = true)
            .performClick()

        assertEquals(Routes.Search.route, navController.currentBackStackEntry?.destination?.route)
    }

    @Test
    fun appBottomBar_selectedStateHighlightsCorrectly() {
        setupBottomBar(Routes.Favourites.route)

        composeTestRule.onNodeWithText("Favourites").assertIsSelected()
        composeTestRule.onNodeWithText("Home").assertIsNotSelected()
        composeTestRule.onNodeWithText("Search").assertIsNotSelected()
    }
}