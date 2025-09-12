
package com.example.myapplication.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Location

@Composable
fun LocationItem(location: Location, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = location.name,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = location.building,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = location.description,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}