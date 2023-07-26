package com.moniapps.palettewave.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moniapps.palettewave.components.TextInput
import com.moniapps.palettewave.components.saveButton
import com.moniapps.palettewave.ui.theme.PaletteWaveTheme
import com.moniapps.palettewave.viewmodels.NoteScreenViewmodel

@Composable
fun NoteScreen(vm: NoteScreenViewmodel = viewModel()) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextInput(
                text = vm.titleText,
                onTextChange = { vm.onTitleTextChange(it) },
                label = "Title",
                singleLine = true,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextInput(
                text = vm.descriptionText,
                onTextChange = { vm.onDescriptionChange(it) },
                label = "Description",
                modifier = Modifier.padding(top = 8.dp)
            )
            saveButton(
                buttonName = "Save",
                onClick = {

                },
                modifier = Modifier.padding(top = 8.dp)
            )

        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FirstScreenPreview() {
    PaletteWaveTheme {
        NoteScreen()
    }
}