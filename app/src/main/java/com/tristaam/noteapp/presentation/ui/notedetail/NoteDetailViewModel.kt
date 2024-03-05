package com.tristaam.noteapp.presentation.ui.notedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tristaam.noteapp.domain.model.Note
import com.tristaam.noteapp.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    private val _note = MutableStateFlow<Note?>(null)
    val note = _note

    fun saveNote(content: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val note = _note.value!!
            noteRepository.updateNote(
                Note(
                    id = note.id,
                    userId = note.userId,
                    content = content
                )
            )
        }
    }

    fun deleteNote() {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.deleteNote(_note.value!!)
        }
    }

    fun setNote(noteId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _note.value = noteRepository.getNoteById(noteId)
        }
    }
}