package com.moniapps.palettewave.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.moniapps.palettewave.model.Note

class NoteScreenViewmodel : ViewModel(){

    var noteList = mutableStateListOf<Note>()
    var titleText by mutableStateOf("")
        private set
    fun onTitleTextChange(title:String){
        titleText = title
    }
    var descriptionText by mutableStateOf("")
        private set

    fun onDescriptionChange(description:String){
        descriptionText = description
    }
    fun onAddNote(note:Note):Boolean{
        return if (titleText.isNotEmpty() && descriptionText.isNotEmpty()) {
            Note(title = titleText, description = descriptionText)
            noteList.add(note)
            true
        }else false
    }
    fun onRemoveNote(note:Note){
        noteList.remove(note)
    }
}