package com.tristaam.noteapp.di

import com.tristaam.noteapp.data.repository.AuthRepositoryImpl
import com.tristaam.noteapp.data.repository.NoteRepositoryImpl
import com.tristaam.noteapp.data.repository.UserRepositoryImpl
import com.tristaam.noteapp.data.source.local.roomdb.dao.NoteDao
import com.tristaam.noteapp.data.source.local.roomdb.dao.UserDao
import com.tristaam.noteapp.data.source.local.roomdb.sharedpref.NoteAppSharedPref
import com.tristaam.noteapp.domain.repository.AuthRepository
import com.tristaam.noteapp.domain.repository.NoteRepository
import com.tristaam.noteapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepositoryImpl(userDao)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(noteAppSharedPref: NoteAppSharedPref): AuthRepository {
        return AuthRepositoryImpl(noteAppSharedPref)
    }
}