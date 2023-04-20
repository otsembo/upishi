package ui.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

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