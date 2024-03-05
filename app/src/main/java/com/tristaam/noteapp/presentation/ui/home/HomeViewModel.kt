package com.tristaam.noteapp.presentation.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tristaam.noteapp.domain.model.Note
import com.tristaam.noteapp.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    private val _allNotes = MutableStateFlow<List<Note>>(emptyList())
    val allNotes = _allNotes.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllNotes()
        }
    }

    private suspend fun getAllNotes() {
        noteRepository.getAllNotes().collect { notes ->
            _allNotes.update {
                Log.d("HomeViewModel", "getAllNotes: ${notes.size}")
                notes
            }
        }
    }
}