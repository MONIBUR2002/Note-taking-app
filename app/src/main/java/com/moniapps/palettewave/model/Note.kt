package com.moniapps.palettewave.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID

@Entity(tableName = "notes_tbl")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "Notes_title")
    val title: String,

    @ColumnInfo(name = "Note_description")
    val description: String,

    @ColumnInfo(name = "Note_entry_date")
    val entryDate: LocalDateTime = LocalDateTime.now()
)
