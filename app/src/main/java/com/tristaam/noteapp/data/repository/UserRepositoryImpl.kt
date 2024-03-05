package com.tristaam.noteapp.data.repository

import com.tristaam.noteapp.data.source.local.roomdb.dao.UserDao
import com.tristaam.noteapp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository