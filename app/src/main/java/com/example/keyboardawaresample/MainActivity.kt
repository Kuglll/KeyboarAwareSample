package com.example.keyboardawaresample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.keyboardawaresample.ui.theme.KeyboardAwareSampleTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KeyboardAwareSampleTheme {
                SearchSongScreen()
            }
        }
    }
}

@Composable
fun SearchSongScreen(
    modifier: Modifier = Modifier,
) {
    var textFieldValue by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val keyboardHeight = WindowInsets.ime.getBottom(LocalDensity.current)

    LaunchedEffect(key1 = keyboardHeight) {
        coroutineScope.launch {
            scrollState.scrollBy(keyboardHeight.toFloat())
        }
    }

    KeyboardAware {
        Column(
            modifier = modifier
                .background(Color.Yellow)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .windowInsetsPadding(WindowInsets.safeContent.only(WindowInsetsSides.Bottom + WindowInsetsSides.Top))
                .padding(horizontal = 16.dp),
        ) {
            Text(
                text = "Search for a song",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(24.dp))
            CustomTextField(
                textFieldValue = textFieldValue,
                onValueChange = { textFieldValue = it },
            )
            Spacer(modifier = Modifier.height(24.dp))
            CustomTextField(
                textFieldValue = textFieldValue,
                onValueChange = { textFieldValue = it },
            )
            Spacer(modifier = Modifier.height(24.dp))
            CustomTextField(
                textFieldValue = textFieldValue,
                onValueChange = { textFieldValue = it },
            )
            Spacer(modifier = Modifier.height(24.dp))
            CustomTextField(
                textFieldValue = textFieldValue,
                onValueChange = { textFieldValue = it },
            )
            Spacer(modifier = Modifier.height(24.dp))
            CustomTextField(
                textFieldValue = textFieldValue,
                onValueChange = { textFieldValue = it },
            )
            Spacer(modifier = Modifier.height(24.dp))
            CustomTextField(
                textFieldValue = textFieldValue,
                onValueChange = { textFieldValue = it },
            )
            Spacer(modifier = Modifier.height(24.dp))
            CustomTextField(
                textFieldValue = textFieldValue,
                onValueChange = { textFieldValue = it },
            )
            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                ),
                contentPadding = PaddingValues(
                    vertical = 16.dp,
                ),
            ) {
                Text(
                    text = "Search",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = textFieldValue,
        onValueChange = onValueChange,
        label = {
            Text(text = "Enter a song")
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(12.dp),
    )
}
