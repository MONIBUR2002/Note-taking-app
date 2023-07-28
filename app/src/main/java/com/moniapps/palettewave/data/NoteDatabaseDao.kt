package com.moniapps.palettewave.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.moniapps.palettewave.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("Select * from notes_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query("Select * from notes_tbl where id = :id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE from notes_tbl")
    suspend fun deleteAll()
}