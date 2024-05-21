package com.example.keyboardawaresample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Component that takes in a content and ensures that it resizes automatically when the keyboard is opened.
 */
@Composable
fun KeyboardAware(
    content: @Composable () -> Unit
) {
    Box(modifier = Modifier.imePadding()) {
        content()
    }
}
