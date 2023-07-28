package com.moniapps.palettewave.viewmodels

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moniapps.palettewave.model.Note
import com.moniapps.palettewave.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewmodel @Inject constructor(private val repository: NoteRepository) :
    ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllnotes().distinctUntilChanged()
                .collect{
                    listOfNotes ->
                    if (listOfNotes.isNullOrEmpty()){
                        Log.d("Empty", ": Empty list")
                    }else{
                        _noteList.value = listOfNotes
                    }
                }
        }
    }
    var titleText by mutableStateOf("")
        private set

    fun onTitleTextChange(title: String) {
        titleText = title
    }

    var descriptionText by mutableStateOf("")
        private set

    fun onDescriptionChange(description: String) {
        descriptionText = description
    }

    suspend fun onAddNote(note: Note): Boolean {
        return if (titleText.isNotEmpty() && descriptionText.isNotEmpty()) {
            viewModelScope.launch {
                Note(title = titleText, description = descriptionText)
                repository.addNote(note)
            }
            true
        } else false
    }

    suspend fun onRemoveNote(note: Note) {
        repository.deleteNote(note)
    }
    suspend fun updateNote(note:Note) = viewModelScope.launch { repository.updateNote(note) }
}


