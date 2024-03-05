package com.tristaam.noteapp.data.repository

import com.tristaam.noteapp.data.mapper.NoteMapper
import com.tristaam.noteapp.data.source.local.roomdb.dao.NoteDao
import com.tristaam.noteapp.domain.model.Note
import com.tristaam.noteapp.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {
    override suspend fun insertNote(note: Note) {
        return withContext(Dispatchers.IO) {
            noteDao.insertNote(NoteMapper.toNoteEntity(note))
        }
    }

    override suspend fun updateNote(note: Note) {
        return withContext(Dispatchers.IO) {
            noteDao.updateNote(NoteMapper.toNoteEntity(note))
        }
    }

    override suspend fun deleteNote(note: Note) {
        return withContext(Dispatchers.IO) {
            noteDao.deleteNote(NoteMapper.toNoteEntity(note))
        }
    }

    override suspend fun getNoteById(noteId: Int): Note {
        return withContext(Dispatchers.IO) {
            NoteMapper.toNote(noteDao.getNoteById(noteId))
        }
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { allNotes ->
            allNotes.map { NoteMapper.toNote(it) }
        }
    }
}