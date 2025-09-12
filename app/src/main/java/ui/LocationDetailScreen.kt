// File: app/src/main/java/com/example/myapplication/ui/LocationDetailScreen.kt
package com.example.myapplication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth  // ADD THIS IMPORT
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

        Button(
            onClick = { /* Add to favorites */ },
            modifier = Modifier.fillMaxWidth()  // This should work now
        ) {
            Text("⭐ Add to Favorites")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* Show directions */ },
            modifier = Modifier.fillMaxWidth()  // This should work now
        ) {
            Text("🚶 Get Directions")
        }
    }
}