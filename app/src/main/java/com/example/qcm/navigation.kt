package com.example.qcm

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun navigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "premierePage"
    ) {
        composable("premierePage") { Accueil(navController) }
        composable("deuxiemePage") { raccourcis_Windows(navController) }
        composable("troisiemePage") { raccourcis_Word(navController) }
        composable("quatriemePage") { raccourcis_Internet(navController) }
        composable("cinquiemePage") { Bonne_rep(navController) }
    }

}
