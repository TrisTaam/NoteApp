package com.tristaam.noteapp.presentation.ui

import androidx.lifecycle.ViewModel
import com.tristaam.noteapp.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    fun isSignedIn(): Boolean {
        return authRepository.isSignedIn()
    }

    fun signIn(userId: Int) {
        authRepository.signIn(userId)
    }

    fun signOut() {
        authRepository.signOut()
    }
}