package ui.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div

@Composable
fun Loader() {
    Div(attrs = {
        classes("progress")
        style {
            width(100.px)
        }
    }) {
        Div(attrs = { classes("indeterminate") }) { }
    }
}