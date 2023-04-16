package data.models

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val categories: List<Category>
)

@Serializable
data class MealResponse(
    val meals: List<Meal>
)