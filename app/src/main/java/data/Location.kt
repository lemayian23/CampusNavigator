package com.example.myapplication.data

data class Location(
    val id: Int,
    val name: String,
    val category: String,
    val description: String,
    val coordinates: String,
    val building: String,
    val floor: String? = null
)