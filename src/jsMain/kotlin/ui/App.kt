package ui

import androidx.compose.runtime.*
import data.models.toFood
import data.repository.AppRepository
import network.AppResource
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text
import ui.components.Loader
import ui.fragments.Meals
import ui.fragments.DayMeal
import ui.fragments.MealCategories

@Composable
fun App(appRepository: AppRepository = AppRepository()){

    // retrieve page data
    val meal = appRepository.getMealOfDay().collectAsState(AppResource.Loading())
    val categories = appRepository.getCategories().collectAsState(AppResource.Loading())
    val desserts = appRepository.getDesserts().collectAsState(AppResource.Loading())

    Div(attrs = {
        classes("container-fluid")
        style {
            padding(2.percent)
        }
    }) {
        Div(attrs = {
            classes("row")
        }){

            Div(attrs = {
                classes("col", "s4")
            }){

                with(meal.value){
                    when(this){
                        is AppResource.Error -> {
                            ErrorMessage(message)
                        }
                        is AppResource.Loading -> {
                            Loader()
                        }
                        is AppResource.Success -> {
                            data?.meals?.get(0)?.let { DayMeal(it.toFood()) }
                        }
                    }
                }

            }

            ColumnSpacer()

            Div(attrs = {
                classes("col", "s7")
            }){

                with(categories.value){
                    when(this){
                        is AppResource.Error -> {
                            ErrorMessage(message)
                        }
                        is AppResource.Loading -> {
                            Loader()
                        }
                        is AppResource.Success -> {
                            val categoriesData =  data?.categories?.map { it.strCategory } ?: emptyList()
                            MealCategories(categories = categoriesData)
                        }
                    }
                }


                with(desserts.value){
                    when(this){
                        is AppResource.Error -> {
                            ErrorMessage(message)
                        }
                        is AppResource.Loading -> {
                            Loader()
                        }
                        is AppResource.Success -> {
                            val dessertData = data?.desserts ?: emptyList()
                            Meals(desserts = dessertData)
                        }
                    }
                }

            }

        }

    }
}

@Composable
fun ColumnSpacer(
    vararg classes: String,
    styleData: StyleScope.() -> Unit = { },
    content: @Composable () -> Unit = { }
){

    Div(attrs = {
        style(styleData)
        classes("col", "s1", *classes)
    }){
        content()
    }

}

@Composable
fun ErrorMessage(message: String?){
    H1 {
        Text(value = message!!)
    }
}
