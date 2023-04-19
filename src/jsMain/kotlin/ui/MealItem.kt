package ui

import androidx.compose.runtime.Composable
import data.models.Food
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.*

@Composable
fun MealItem(food: Food) {
    Div(attrs = {
        classes("col", "s12", "m6", "l4")
        style {
            padding(5.percent)
        }
    }) {

        Div(attrs = {
            classes("card")
        }) {

            // card image div
            Div(attrs = {
                classes("card-image")
            }) {

                // card image
                Div(attrs = {
                    classes("card-image")
                }) {
                    Img( src = food.thumbnail, attrs = {
                        classes("responsive-img")
                    })
                }

                // card title
                Div(attrs = {
                    classes("card-title")
                }) {
                    H1 {
                        Text(food.name)
                    }
                }

            }

            // card content
            Div(attrs = {
                classes("card-content")
            }) {
                P {
                    Text(food.description)
                }
            }

        }

    }
}