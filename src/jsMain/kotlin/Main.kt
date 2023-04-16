import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import data.repository.AppRepository
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import ui.DayMeal

// app data
val repository = AppRepository()

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

            Div(attrs = {
                classes("col", "s8")
            }){
                Text("Hello World")
            }

        }

    }
}
