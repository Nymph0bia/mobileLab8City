package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.DataSource
import com.example.mycity.ui.theme.MyCityTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetailScreen(placeName: String, onBackClick: () -> Unit) {
    val place = DataSource.places.values.flatten().find { it.name == placeName }

    Scaffold(
        topBar = {
            MyCityAppBar(
                title = place?.name ?: "Место",
                canNavigateBack = true,
                navigateUp = onBackClick
            )
        }
    ) { padding ->
        place?.let {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(it.imageRes),
                    contentDescription = it.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(Modifier.height(16.dp))
                Text(it.description)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPlaceDetailScreen() {
    MyCityTheme {
        PlaceDetailScreen(
            placeName = "Surf Coffee",
            onBackClick = {}
        )
    }
}