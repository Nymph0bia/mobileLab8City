package com.example.mycity.data
import com.example.mycity.R

data class Place(val name: String, val description: String, val imageRes: Int)

object DataSource {
    val categories = listOf("Кофейни", "Рестораны", "Парки", "Торговые центры")

    val places = mapOf(
        "Кофейни" to listOf(
            Place("Surf Coffee", "Атмосферная кофейня с видом на Кремль.", R.drawable.surf_coffee),
            Place("Skuratov", "Отличный кофе и уютная атмосфера.", R.drawable.skuratov)
        ),
        "Рестораны" to listOf(
            Place("OKO", "Авторская кухня с видом на центр города.", R.drawable.oko),
            Place("Горыныч", "Одно из лучших мест для знакомства с кухней Казани.", R.drawable.gorinic)
        ),
        "Парки" to listOf(
            Place("Парк Урам", "Место, где объединились спортивное и творческое комьюнити.", R.drawable.uram),
            Place("Черное озеро", "Тихое место для прогулок в центре города.", R.drawable.black_lake)
        ),
        "Торговые центры" to listOf(
            Place("MEGA Казань", "Крупный торговый центр с IKEA и кинотеатром.", R.drawable.mega),
            Place("Кольцо", "ТЦ в центре города у одноимённой площади.", R.drawable.koltso)
        )
    )
}
