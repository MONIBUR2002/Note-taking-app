package com.moniapps.palettewave.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NoteScreenViewmodel : ViewModel(){
    var titleText by mutableStateOf("")
        private set
    fun onTitleTextChange(title:String){
        titleText = title
    }
    var descriptionText by mutableStateOf("")

    fun onDescriptionChange(description:String){
        descriptionText = description
    }

}