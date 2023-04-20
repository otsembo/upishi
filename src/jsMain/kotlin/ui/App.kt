package ui

import androidx.compose.runtime.*
import data.repository.AppRepository
import network.AppResource
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Div
import ui.components.Meals
import ui.fragments.DayMeal
import ui.fragments.MealCategories

@Composable
fun App(appRepository: AppRepository = AppRepository()){

    val meal = appRepository.getMealOfDay().collectAsState(AppResource.Loading())
    val category = appRepository.getCategories().collectAsState(AppResource.Loading())
    val dessert = appRepository.getDesserts().collectAsState(AppResource.Loading())

    Div(attrs = {
        classes("container")
        style {
            paddingTop(5.percent)
        }
    }) {
        Div(attrs = {
            classes("row")
        }){

            Div(attrs = {
                classes("col", "s4")
            }){

                when(meal.value){
                    is AppResource.Success -> {

                    }
                    is AppResource.Error -> {

                    }
                    else -> {

                    }
                }

            }

            ColumnSpacer()

            Div(attrs = {
                classes("col", "s7")
            }){

                MealCategories()

                Meals()
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
