package com.example.mycity.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.DataSource
import com.example.mycity.ui.theme.MyCityTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(onCategoryClick: (String) -> Unit = {}) {
    Scaffold(
        topBar = {
            MyCityAppBar(
                title = "Мой город: Казань",
                canNavigateBack = false
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = "Выберите категорию:",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(16.dp))

            val categories = listOf("Кофейни", "Рестораны", "Парки", "Торговые центры")

            categories.forEach { category ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onCategoryClick(category) }
                ) {
                    Text(category, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryListScreen() {
    MyCityTheme {
        CategoryListScreen(onCategoryClick = {})
    }
}
