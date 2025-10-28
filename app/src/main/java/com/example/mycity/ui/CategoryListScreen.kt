package com.example.mycity.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.Park
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.DataSource
import com.example.mycity.ui.theme.MyCityTheme

data class CategoryItem(
    val name: String,
    val icon: @Composable () -> Unit
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(onCategoryClick: (String) -> Unit = {}) {
    val categories = listOf(
        CategoryItem("Кофейни", { Icon(Icons.Default.LocalCafe, contentDescription = null) }),
        CategoryItem("Рестораны", { Icon(Icons.Default.Restaurant, contentDescription = null) }),
        CategoryItem("Парки", { Icon(Icons.Default.Park, contentDescription = null) }),
        CategoryItem("Торговые центры", { Icon(Icons.Default.Store, contentDescription = null) })
    )

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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Выберите категорию:",
                style = MaterialTheme.typography.titleMedium
            )

            categories.forEach { category ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCategoryClick(category.name) },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        category.icon()
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            category.name,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryListScreen() {
    MyCityTheme {
        CategoryListScreen()
    }
}