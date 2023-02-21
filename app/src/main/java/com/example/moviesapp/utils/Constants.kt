package com.example.moviesapp.utils

import android.widget.TextView
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.example.moviesapp.R

class Constants {

    object Screens {
        const val SPLASH_SCREEN = "splash_screen"
        const val MAIN_SCREEN = "main_screen"
        const val DETAILS_SCREEN = "details_screen"
    }
}

@Composable
    fun HtmlText(html: String, modifier: Modifier = Modifier, darkTheme: Boolean = isSystemInDarkTheme()) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            TextView(context).apply {
                if (darkTheme) {
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                } else {
                    setTextColor(ContextCompat.getColor(context, R.color.black))
                }
            }
        },
        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT) }
    )
}