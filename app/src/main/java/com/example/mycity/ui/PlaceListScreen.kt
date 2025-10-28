package com.example.mycity.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.DataSource
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.ui.theme.RedSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceListScreen(category: String, onPlaceClick: (String) -> Unit, onBackClick: () -> Unit) {
    val places = DataSource.places[category] ?: emptyList()
    Scaffold(
        topBar = {
            MyCityAppBar(
                title = category,
                canNavigateBack = true,
                navigateUp = onBackClick
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            places.forEach { place ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onPlaceClick(place.name) },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer  // ← вот оно!
                    ),
                ) {
                    Text(place.name, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPlaceListScreen() {
    MyCityTheme {
        PlaceListScreen(
            category = "Кофейни",
            onPlaceClick = {},
            onBackClick = {}
        )
    }
}
