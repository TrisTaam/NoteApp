package com.tristaam.noteapp.data.mapper

import com.tristaam.noteapp.data.source.local.roomdb.entity.NoteEntity
import com.tristaam.noteapp.domain.model.Note

object NoteMapper {
    fun toNoteEntity(note: Note): NoteEntity {
        return NoteEntity(
            id = note.id,
            userId = note.userId,
            content = note.content,
        )
    }

    fun toNote(noteEntity: NoteEntity): Note {
        return Note(
            id = noteEntity.id,
            userId = noteEntity.userId,
            content = noteEntity.content,
        )
    }
}