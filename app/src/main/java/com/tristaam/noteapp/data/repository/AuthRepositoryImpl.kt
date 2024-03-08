package com.tristaam.noteapp.data.repository

import com.tristaam.noteapp.data.source.local.roomdb.sharedpref.NoteAppSharedPref
import com.tristaam.noteapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val noteAppSharedPref: NoteAppSharedPref
) : AuthRepository {
    override fun isSignedIn(): Boolean {
        return getSignedInUserId() != -1
    }

    override fun signIn(userId: Int) {
        noteAppSharedPref.put("user_id", userId)
    }

    override fun signOut() {
        noteAppSharedPref.put("user_id", -1)
    }

    override fun getSignedInUserId(): Int {
        return noteAppSharedPref.get("user_id", -1)
    }
}