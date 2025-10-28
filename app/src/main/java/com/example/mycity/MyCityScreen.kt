package com.example.mycity

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.*

enum class MyCityScreen {
    Categories, Places, Details
}

@Composable
fun MyCityApp() {
    val navController = rememberNavController()
    var selectedCategory by remember { mutableStateOf("") }
    var selectedPlace by remember { mutableStateOf("") }

    NavHost(navController, startDestination = MyCityScreen.Categories.name) {

        composable(MyCityScreen.Categories.name) {
            CategoryListScreen(
                onCategoryClick = {
                    selectedCategory = it
                    navController.navigate(MyCityScreen.Places.name)
                }
            )
        }

        composable(MyCityScreen.Places.name) {
            PlaceListScreen(
                category = selectedCategory,
                onPlaceClick = {
                    selectedPlace = it
                    navController.navigate(MyCityScreen.Details.name)
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(MyCityScreen.Details.name) {
            PlaceDetailScreen(
                placeName = selectedPlace,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}