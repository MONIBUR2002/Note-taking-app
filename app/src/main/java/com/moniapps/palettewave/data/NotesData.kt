package com.moniapps.palettewave.data

import com.moniapps.palettewave.model.Note

class noteDateSource(){
    fun loadNotes():List<Note>{
        return listOf(
            Note(title = "Note 1", description = "This is the description of Note 1."),
            Note(title = "Note 2", description = "Description for Note 2 goes here."),
            Note(title = "Note 3", description = "A sample description for Note 3."),
            Note(title = "Note 4", description = "Description for Note 4."),
            Note(title = "Note 5", description = "Description for Note 5."),
            Note(title = "Note 6", description = "Description for Note 6."),
            Note(title = "Note 7", description = "This is the description of Note 7."),
            Note(title = "Note 8", description = "Description for Note 8."),
            Note(title = "Note 9", description = "Description for Note 9."),
            Note(title = "Note 10", description = "Description for Note 10."),
            Note(title = "Note 11", description = "This is the description of Note 11."),
            Note(title = "Note 12", description = "Description for Note 12."),
        )
    }
}