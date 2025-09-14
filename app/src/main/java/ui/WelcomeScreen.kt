package com.example.myapplication.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavController) {
    var showContent by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(300)
        showContent = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2C3E50),  // Dark blue (academic color)
                        Color(0xFF3498DB)   // Light blue
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 32.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // University Navigation Icon
            AnimatedVisibility(
                visible = showContent,
                enter = fadeIn(animationSpec = tween(1000)) +
                        slideInVertically(initialOffsetY = { -50 }, animationSpec = tween(1000))
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(24.dp))
                        .padding(20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "🏛️",  // University building
                            fontSize = 48.sp
                        )
                        Text(
                            text = "➡️",  // Navigation arrow
                            fontSize = 28.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Title with academic feel
            AnimatedVisibility(
                visible = showContent,
                enter = fadeIn(animationSpec = tween(1000, delayMillis = 300)) +
                        slideInVertically(initialOffsetY = { 30 }, animationSpec = tween(1000, delayMillis = 300))
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Campus Navigator",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        letterSpacing = 1.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "University Wayfinding System",
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Animated features list
            AnimatedVisibility(
                visible = showContent,
                enter = fadeIn(animationSpec = tween(800, delayMillis = 400)) +
                        slideInVertically(initialOffsetY = { 30 }, animationSpec = tween(800, delayMillis = 400))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    FeatureText("📍 Find any campus location")
                    FeatureText("⭐ Save favorite spots")
                    FeatureText("🚶 Get easy directions")
                    FeatureText("🔍 Smart search functionality")
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Animated button
            AnimatedVisibility(
                visible = showContent,
                enter = fadeIn(animationSpec = tween(800, delayMillis = 600)) +
                        slideInVertically(initialOffsetY = { 30 }, animationSpec = tween(800, delayMillis = 600))
            ) {
                Button(
                    onClick = {
                        navController.navigate("main") {
                            popUpTo("welcome") { inclusive = true }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(56.dp)
                        .shadow(8.dp, RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFF2C3E50)  // Dark blue to match theme
                    )
                ) {
                    Text(
                        text = "Explore Campus",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        // Copyright footer - positioned at bottom
        AnimatedVisibility(
            visible = showContent,
            enter = fadeIn(animationSpec = tween(1000, delayMillis = 800))
        ) {
            Text(
                text = "© 2024 Campus Navigator • v1.0.0",
                color = Color.White.copy(alpha = 0.6f),
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp)
            )
        }
    }
}

@Composable
fun FeatureText(text: String) {
    Text(
        text = text,
        color = Color.White.copy(alpha = 0.8f),
        fontSize = 14.sp,
        modifier = Modifier.padding(vertical = 4.dp),
        textAlign = TextAlign.Center
    )
}