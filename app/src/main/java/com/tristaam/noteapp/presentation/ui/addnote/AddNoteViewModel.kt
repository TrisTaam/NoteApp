package com.tristaam.noteapp.presentation.ui.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tristaam.noteapp.domain.model.Note
import com.tristaam.noteapp.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    fun addNote(content: String) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.insertNote(
                Note(
                    userId = 1,
                    content = content
                )
            )
        }
    }
}