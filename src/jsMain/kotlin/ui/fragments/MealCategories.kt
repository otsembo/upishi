package ui.fragments

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import ui.components.RowItem
import ui.components.SectionTitle

// TODO: Add Meal Categories
@Composable
fun MealCategories(categories: List<String> = listOf("Breakfast", "Lunch", "Dinner", "Snacks")) {

}

//TODO: Add Category Item / Badge (MaterializeCSS)
@Composable
fun CategoryBadge(category: String) {
    val colors = arrayOf("red", "green", "blue", "yellow", "lime", "purple",
        "pink", "indigo", "deep-purple", "teal", "cyan")
}