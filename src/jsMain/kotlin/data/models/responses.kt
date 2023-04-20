package data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val categories: List<Category>
)

@Serializable
data class MealResponse(
    val meals: List<Meal>
)

@Serializable
data class DessertResponse(
    @SerialName("meals")
    val desserts: List<Dessert>
)
