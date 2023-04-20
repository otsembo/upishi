package data.repository

import data.models.CategoryResponse
import data.models.Dessert
import data.models.DessertResponse
import data.models.MealResponse
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import network.APIConfig
import network.AppResource

class AppRepository {
    private val config = APIConfig

    // load meal of the day
    fun getMealOfDay(): Flow<AppResource<MealResponse>> = flow {
        try {
            emit(AppResource.Loading())
            val mealOfDay = config.client.get("${config.BASE_URL}random.php").body<MealResponse>()
            emit(AppResource.Success(mealOfDay))
        }catch (e: Exception){
            emit(AppResource.Error(e.message ?: "An error occurred"))
        }
    }

    // load all categories
    fun getCategories(): Flow<AppResource<CategoryResponse>> = flow {
        try {
            emit(AppResource.Loading())
            val categories = config.client.get("${config.BASE_URL}categories.php").body<CategoryResponse>()
            emit(AppResource.Success(categories))
        }catch (e: Exception){
            emit(AppResource.Error(e.message ?: "An error occurred"))
        }
    }

    // load all desserts
    fun getDesserts(): Flow<AppResource<DessertResponse>> = flow {
        try {
            emit(AppResource.Loading())
            val desserts = config.client.get("${config.BASE_URL}filter.php?c=Dessert").body<DessertResponse>()
            emit(AppResource.Success(desserts))
        }catch (e: Exception){
            emit(AppResource.Error(e.message ?: "An error occurred"))
        }
    }

}