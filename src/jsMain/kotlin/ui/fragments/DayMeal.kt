package ui.fragments

import androidx.compose.runtime.*
import data.models.Food
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

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

@Composable
fun LoadingBar(isLoading: Boolean = false){
    Div (attrs = {
        style{
            border(16.px,  LineStyle.Solid, color = Color("#f3f3f3"))
            border(16.px,  LineStyle.Solid, color = Color("#3498db"))
            borderRadius(50.percent)
            width(120.px)
            height(120.px)
            display(if (isLoading) DisplayStyle.Flex else DisplayStyle.None)
        }
    }){

    }
}

@Composable
fun RowItem(vararg classes: String, style: StyleScope.() -> Unit = { }, content: @Composable () -> Unit){
    Div(attrs = {
        classes("row", *classes)
        style(style)
    }) {
        content()
    }
}

@Composable
fun SectionTitle(title: String = "Hello Title", icon: String = "check_circle"){

    RowItem {

        H1(attrs = {
            style {
                fontSize(20.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row)
                alignContent(AlignContent.SpaceBetween)
            }
        }) {

            Span(attrs = {
                classes("material-icons")
                style {
                    marginRight(10.px)
                }
            }) {
                Text(value = icon)
            }

            Text(value = title)
        }

    }


}