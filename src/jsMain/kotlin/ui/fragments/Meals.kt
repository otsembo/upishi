package ui.fragments

import androidx.compose.runtime.Composable
import data.models.Dessert
import org.jetbrains.compose.web.dom.Div
import ui.components.MealItem
import ui.components.RowItem
import ui.components.SectionTitle

@Composable
fun Meals( desserts: List<Dessert> = emptyList() ){
    RowItem {
        SectionTitle(title = "Popular", icon = "favorite")
    }

    RowItem{
        Div(attrs = {
            classes("row")
        }){

            desserts.forEach { dessert ->
                MealItem(dessert = dessert)
            }

        }
    }
}