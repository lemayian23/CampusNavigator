package com.example.myapplication.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.MainScreen
import com.example.myapplication.ui.LocationDetailScreen
import com.example.myapplication.data.LocationData

@Composable
fun CampusNavApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController = navController)
        }
        composable(
            "details/{locationId}",
            arguments = listOf(navArgument("locationId") { type = NavType.IntType })
        ) { backStackEntry ->
            val locationId = backStackEntry.arguments?.getInt("locationId")
            val location = LocationData.locations.find { it.id == locationId }
            LocationDetailScreen(location = location, navController = navController)
        }
    }
}

@Preview
@Composable
fun PreviewCampusNavApp() {
    CampusNavApp()
}