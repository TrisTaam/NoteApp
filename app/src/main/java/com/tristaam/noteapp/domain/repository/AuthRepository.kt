package com.tristaam.noteapp.domain.repository

interface AuthRepository {
    fun isSignedIn(): Boolean
    fun signIn(userId: Int)
    fun signOut()
    fun getSignedInUserId(): Int
}