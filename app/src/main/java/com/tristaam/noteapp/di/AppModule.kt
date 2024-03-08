package com.tristaam.noteapp.di

import android.app.Application
import com.tristaam.noteapp.data.source.local.roomdb.sharedpref.NoteAppSharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideNoteAppSharedPref(application: Application): NoteAppSharedPref {
        return NoteAppSharedPref(application)
    }
}