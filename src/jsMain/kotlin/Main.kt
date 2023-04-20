import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import ui.DayMeal
import ui.MealCategories
import ui.Meals

fun main() {
    renderComposable(rootElementId = "root") {
       App()
    }
}

@Composable
fun App(){
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
                DayMeal()
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