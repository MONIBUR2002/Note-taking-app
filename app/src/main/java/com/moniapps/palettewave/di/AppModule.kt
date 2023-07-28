package com.moniapps.palettewave.di

import android.content.Context
import androidx.room.Room
import com.moniapps.palettewave.data.NoteDatabase
import com.moniapps.palettewave.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase):NoteDatabaseDao{
        return noteDatabase.noteDao()
    }
    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context):NoteDatabase
        = Room.databaseBuilder(
        context = context,
        klass = NoteDatabase::class.java,
        name = "note_db"
        ).fallbackToDestructiveMigration().build()

}