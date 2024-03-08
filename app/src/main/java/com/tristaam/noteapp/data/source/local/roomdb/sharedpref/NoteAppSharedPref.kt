package com.tristaam.noteapp.data.source.local.roomdb.sharedpref

import android.app.Application
import android.content.Context.MODE_PRIVATE
import javax.inject.Inject

class NoteAppSharedPref @Inject constructor(
    private val application: Application
) {
    companion object {
        const val SHARED_PREF_NAME = "NoteAppSharedPref"
    }

    fun put(key: String, value: Int) {
        val sharedPref = application.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt(key, value)
            apply()
        }
    }

    fun get(key: String, defaultValue: Int): Int {
        val sharedPref = application.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)
        return sharedPref.getInt(key, defaultValue)
    }
}