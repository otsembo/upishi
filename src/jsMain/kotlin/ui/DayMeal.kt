package ui

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun DayMeal(){

    var isLoading: Boolean by remember {
        mutableStateOf(false)
    }

    LoadingBar(isLoading = isLoading)

    Div(attrs = {
        style{
            display( if(!isLoading)  DisplayStyle.Block else DisplayStyle.None)
        }
    }) {
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
                    Text("home")
                }

                Text("Today's Meal")
            }
        }

        RowItem {
            Img(src = "https://www.themealdb.com/images/media/meals/58oia61564916529.jpg", attrs = {
                style {
                    width(100.percent)
                    height(350.px)
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
                Text("Curry Chicken")
            }
        }

        RowItem {
            H2(attrs = {
                style {
                    color(Color("#999"))
                    fontSize(24.px)
                }
            }) {
                Text("A small description of the meal")
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
fun RowItem(content: @Composable () -> Unit){
    Div(attrs = {
        classes("row")
    }) {
        content()
    }
}