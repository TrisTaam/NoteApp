package com.tristaam.noteapp.domain.model

data class Note(
    val id: Int = 0,
    val userId: Int,
    val content: String
)