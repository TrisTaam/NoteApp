package com.tristaam.noteapp.domain.repository

import com.tristaam.noteapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun getNoteById(noteId: Int): Note
    fun getAllNotes(): Flow<List<Note>>
}