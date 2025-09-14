package com.example.myapplication.data

object LocationData {
    val locations = listOf(
        Location(
            id = 1,
            name = "Library",
            category = "LIBRARY",
            description = "Central library with study spaces and books",
            coordinates = "-1.286389,36.817223",
            building = "Library Complex opposite Main Canteen"
        ),
        Location(
            id = 2,
            name = "Student Cafe",
            category = "CAFE",
            description = "Coffee, snacks, and sandwiches",
            coordinates = "-1.286500,36.817500",
            building = "Student Center"
        ),
        Location(
            id = 3,
            name = "Computer Lab",
            category = "ACADEMIC",
            description = "24/7 computer access with printers",
            coordinates = "-1.286200,36.817100",
            building = "D Block",
            floor = "3rd Floor- D23"
        )
    )
}