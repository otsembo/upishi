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

    // TODO: Add Main Container

}

// TODO: Add Spacer (css classes, style, content)
@Composable
fun ColumnSpacer(){

}

// TODO: Add Error Message
@Composable
fun ErrorMessage(message: String?){

}
