package com.tristaam.noteapp.di

import android.app.Application
import androidx.room.Room
import com.tristaam.noteapp.data.source.local.roomdb.NoteAppDatabase
import com.tristaam.noteapp.data.source.local.roomdb.dao.NoteDao
import com.tristaam.noteapp.data.source.local.roomdb.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): NoteAppDatabase {
        return Room.databaseBuilder(
            application,
            NoteAppDatabase::class.java,
            NoteAppDatabase.DATABASE_NAME
        ).addCallback(NoteAppDatabase.callback).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(noteAppDatabase: NoteAppDatabase): UserDao {
        return noteAppDatabase.userDao
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteAppDatabase: NoteAppDatabase): NoteDao {
        return noteAppDatabase.noteDao
    }
}