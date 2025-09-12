package com.example.myapplication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.data.Location

@Composable
fun LocationDetailScreen(location: Location?, navController: NavController) {
    if (location == null) {
        Text("Location not found")
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = location.name,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Building: ${location.building}",
            style = MaterialTheme.typography.bodyLarge
        )
        location.floor?.let {
            Text(text = "Floor: $it")
        }
        Text(
            text = location.description,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

// Add buttons to LocationDetailScreen.kt
        Button(onClick = { /* Add to favorites */ }) {
            Text("⭐ Add to Favorites")
        }

        Button(onClick = {
            // Show text directions like: "Go to Science Block, 2nd Floor"
        }) {
            Text("🚶 Get Directions")
        }
    }
}