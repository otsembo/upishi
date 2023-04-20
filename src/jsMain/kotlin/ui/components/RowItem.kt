package ui.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.dom.Div

@Composable
fun RowItem(vararg classes: String, style: StyleScope.() -> Unit = { }, content: @Composable () -> Unit){
    Div(attrs = {
        classes("row", *classes)
        style(style)
    }) {
        content()
    }
}