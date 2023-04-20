package ui.fragments

import androidx.compose.runtime.*
import data.models.Food
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import ui.components.RowItem
import ui.components.SectionTitle

// Meal of the day
@Composable
fun DayMeal(food: Food){

    Div{

        SectionTitle(title = "Today's Meal", icon = "home")

        RowItem {
            Img(src = food.thumbnail, attrs = {
                style {
                    width(100.percent)
                    height(450.px)
                }
            })
        }

        RowItem {
            H1(attrs = {
                style  {
                    fontSize(26.px)
                    color(Color("#555"))
                }
            }) {
                Text(food.name)
            }
        }

        RowItem {
            H2(attrs = {
                style {
                    color(Color("#999"))
                    fontSize(24.px)
                }
            }) {
                Text(food.description)
            }
        }

    }
}
