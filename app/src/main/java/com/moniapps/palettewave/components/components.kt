package com.moniapps.palettewave.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moniapps.palettewave.model.Note
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextInput(
    text: String,
    onTextChange: (String) -> Unit,
    label: String,
    singleLine: Boolean = false,
    onImeAction: () -> Unit = {},
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
fun SaveButton(
    buttonName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Button(
        onClick =  onClick ,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue
        ),
        modifier = modifier
    ) {
        Text(text = buttonName, fontSize = 24.sp)
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClick: (note:Note) -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(16f))
            .fillMaxWidth(),

        shadowElevation = 4.dp
    ) {
        Column(
            modifier
                .padding(8.dp)
                .clickable {
                           onNoteClick(note)
                },
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = note.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = note.entryDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")),
                style = MaterialTheme.typography.bodySmall
            )

        }

    }
}
