package com.example.qcm

import android.content.Context
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import org.junit.Rule
import org.junit.Test
import androidx.test.core.app.ApplicationProvider

class AccueilTest {
    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun testButtonsPresent() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val navController = NavController(context)

        composeTestRule.setContent {
            Accueil(navController = navController)
        }

        composeTestRule.onNodeWithText("Liste des QCM").assertExists()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Windows !").assertExists()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Word !").assertExists()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Internet !").assertExists()
    }

    @Test
    fun test_supression() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val navController = NavController(context)

        composeTestRule.setContent {
            Accueil(navController = navController)
        }

        composeTestRule.onNodeWithText("Liste des QCM").assertExists()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Windows !").assertExists()
        composeTestRule.onNodeWithContentDescription("Windows").assertExists()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Word !").assertExists()
        composeTestRule.onNodeWithContentDescription("Word").assertExists()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Internet !").assertExists()
        composeTestRule.onNodeWithContentDescription("Internet").assertExists()


        //Suppression QCM Windows
        composeTestRule.onNodeWithContentDescription("Windows").performClick()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Windows !").assertDoesNotExist()
        composeTestRule.onNodeWithContentDescription("Windows").assertDoesNotExist()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Word !").assertExists()
        composeTestRule.onNodeWithContentDescription("Word").assertExists()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Internet !").assertExists()
        composeTestRule.onNodeWithContentDescription("Internet").assertExists()

        //Suppression QCM Word
        composeTestRule.onNodeWithContentDescription("Word").performClick()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Windows !").assertDoesNotExist()
        composeTestRule.onNodeWithContentDescription("Windows").assertDoesNotExist()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Word !").assertDoesNotExist()
        composeTestRule.onNodeWithContentDescription("Word").assertDoesNotExist()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Internet !").assertExists()
        composeTestRule.onNodeWithContentDescription("Internet").assertExists()

        //Suppression QCM Internet
        composeTestRule.onNodeWithContentDescription("Internet").performClick()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Windows !").assertDoesNotExist()
        composeTestRule.onNodeWithContentDescription("Windows").assertDoesNotExist()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Word !").assertDoesNotExist()
        composeTestRule.onNodeWithContentDescription("Word").assertDoesNotExist()
        composeTestRule.onNodeWithText("QCM sur les raccourcis Internet !").assertDoesNotExist()
        composeTestRule.onNodeWithContentDescription("Internet").assertDoesNotExist()
    }
}