package com.example.qcm

import android.content.Context
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import org.junit.Rule
import org.junit.Test
import androidx.test.core.app.ApplicationProvider

class QCM_Test {
    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun testQCMWindows() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val NavHostController = NavHostController(context)

        composeTestRule.setContent {
            raccourcis_Windows(navController = NavHostController)
        }

        composeTestRule.onNodeWithText("Quel raccourci clavier permet de minimiser toutes les fenêtres actives sur Windows ?").assertExists()
        composeTestRule.onNodeWithText("Windows+D").assertExists()
        composeTestRule.onNodeWithText("Windows+F").assertExists()
        composeTestRule.onNodeWithText("Windows+L").assertExists()
        composeTestRule.onNodeWithText("Windows+.").assertExists()
        composeTestRule.onNodeWithText("Windows+D").performClick()
        composeTestRule.onNodeWithText("Bonne réponse !").assertExists()
    }

    @Test
    fun testQCMWord() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val NavHostController = NavHostController(context)

        composeTestRule.setContent {
            raccourcis_Word(navController = NavHostController)
        }

        composeTestRule.onNodeWithText("Comment sélectionner tout le texte dans Microsoft Word à l'aide d'un raccourci clavier ?").assertExists()
        composeTestRule.onNodeWithText("Ctrl+S").assertExists()
        composeTestRule.onNodeWithText("Ctrl+A").assertExists()
        composeTestRule.onNodeWithText("Ctrl+X").assertExists()
        composeTestRule.onNodeWithText("Ctrl+E").assertExists()
        composeTestRule.onNodeWithText("Ctrl+A").performClick()
        composeTestRule.onNodeWithText("Bonne réponse !").assertExists()
    }

    @Test
    fun testQCMInternet() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val NavHostController = NavHostController(context)

        composeTestRule.setContent {
            raccourcis_Internet(navController = NavHostController)
        }

        composeTestRule.onNodeWithText("Quel raccourci clavier ouvre une nouvelle fenêtre de navigateur dans la plupart des navigateurs Web ?").assertExists()
        composeTestRule.onNodeWithText("Ctrl+N").assertExists()
        composeTestRule.onNodeWithText("Ctrl+P").assertExists()
        composeTestRule.onNodeWithText("Ctrl+W").assertExists()
        composeTestRule.onNodeWithText("Alt+F4").assertExists()
        composeTestRule.onNodeWithText("Ctrl+N").performClick()
        composeTestRule.onNodeWithText("Bonne réponse !").assertExists()
    }
}