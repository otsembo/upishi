package ui

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun MealCategories(categories: List<String> = listOf("Breakfast", "Lunch", "Dinner", "Snacks")) {

    RowItem {
        SectionTitle(title = "Categories", icon = "apps")
    }

    RowItem{
        Div(attrs = {
            classes("row")
        }){
            categories.forEach { category ->
                CategoryBadge(category)
            }
        }
    }

    RowItem {
        SectionTitle(title = "Popular", icon = "favorite")
    }

    RowItem{
        Div(attrs = {
            classes("row")
        }){
            categories.forEach { category ->
                CategoryBadge(category)
            }
        }
    }



}

@Composable
fun CategoryBadge(category: String) {
    val colors = arrayOf("red", "green", "blue", "yellow", "lime", "purple",
        "pink", "indigo", "deep-purple", "teal", "cyan")
    // materialize css badge
    Div(attrs = {
        classes("new", "badge", "col", "darken-4", colors.random())
        style {
            padding(10.px)
            margin(10.px)
        }
    }) {
        A(attrs = {
            href("#")
            style {
                color(Color.white)
                fontStyle("bold")
                textDecoration("none")
            }
        }){
            Span {
                Text(category)
            }
        }
    }
}