package ui.components

import androidx.compose.runtime.Composable
import data.models.Dessert
import org.jetbrains.compose.web.dom.Div
import ui.fragments.RowItem
import ui.fragments.SectionTitle

@Composable
fun Meals(){
    RowItem {
        SectionTitle(title = "Popular", icon = "favorite")
    }

    RowItem{
        Div(attrs = {
            classes("row")
        }){

            MealItem(dessert = Dessert("1", "Chicken", "https://www.themealdb.com/images/media/meals/58oia61564916529.jpg"))

        }
    }
}