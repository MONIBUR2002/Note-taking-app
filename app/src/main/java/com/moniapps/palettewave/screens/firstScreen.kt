package com.moniapps.palettewave.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moniapps.palettewave.R
import com.moniapps.palettewave.components.NoteRow
import com.moniapps.palettewave.components.SaveButton
import com.moniapps.palettewave.components.TextInput
import com.moniapps.palettewave.data.noteDateSource
import com.moniapps.palettewave.model.Note
import com.moniapps.palettewave.ui.theme.PaletteWaveTheme
import com.moniapps.palettewave.viewmodels.NoteScreenViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    vm: NoteScreenViewmodel = viewModel(),
    context: Context = LocalContext.current
) {
    val notes = vm.noteList
    val note = Note(title = vm.titleText, description = vm.descriptionText)
    Column {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = Color.White
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Blue
            )
        )
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),

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
                SaveButton(
                    buttonName = "Save",
                    onClick = {
                    if (vm.onAddNote(note)) Toast.makeText(context, "Note added", Toast.LENGTH_SHORT).show()
                    else Toast.makeText(context, "Title or Description is empty", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .size(width = 150.dp, height = 50.dp)
                )
                Divider(modifier = Modifier.padding(12.dp))
                LazyColumn {
                    items(notes) { note ->
                        NoteRow(
                            note = note,
                            onNoteClick = {
                               vm.onRemoveNote(it)
                            }
                        )
                    }
                }
            }
        }
    }
}