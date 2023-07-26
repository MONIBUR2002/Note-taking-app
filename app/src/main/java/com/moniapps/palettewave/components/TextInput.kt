package com.moniapps.palettewave.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextInput(
    text: String,
    onTextChange: (String)->Unit,
    label : String,
    singleLine: Boolean = false,
    onImeAction: ()-> Unit = {},
    modifier: Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        label = { Text(text = label) },
        singleLine = singleLine,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = androidx.compose.ui.text.input.ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboardController?.hide()
            }
        )
    )
}

@Composable
fun saveButton(
    buttonName: String,
    onClick:()->Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { onClick },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue
        ),
        modifier = modifier
    ) {
        Text(text = buttonName)
    }
}