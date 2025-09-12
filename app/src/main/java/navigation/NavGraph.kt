package com.example.myapplication.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import com.example.myapplication.ui.MainScreen
import com.example.myapplication.ui.LocationDetailScreen
import com.example.myapplication.ui.WelcomeScreen  // ADD THIS IMPORT
import com.example.myapplication.data.LocationData

@Composable
fun CampusNavApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }
        composable("main") {
            MainScreen(navController = navController)
        }
        composable(
            "details/{locationId}",
            arguments = listOf(navArgument("locationId") { type = NavType.IntType })
        ) { backStackEntry ->
            val locationId = backStackEntry.arguments?.getInt("locationId")
            val location = LocationData.locations.find { it.id == locationId }
            if (location != null) {
                LocationDetailScreen(location = location, navController = navController)
            } else {
                // Fallback if location not found
                MainScreen(navController = navController)
            }
        }
    }
}