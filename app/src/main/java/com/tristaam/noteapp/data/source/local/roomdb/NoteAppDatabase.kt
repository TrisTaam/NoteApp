package com.tristaam.noteapp.data.source.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tristaam.noteapp.data.source.local.roomdb.dao.NoteDao
import com.tristaam.noteapp.data.source.local.roomdb.dao.UserDao
import com.tristaam.noteapp.data.source.local.roomdb.entity.NoteEntity
import com.tristaam.noteapp.data.source.local.roomdb.entity.UserEntity

@Database(
    entities = [UserEntity::class, NoteEntity::class],
    version = 1
)
abstract class NoteAppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "NoteAppDatabase.db"
        val callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                db.execSQL("INSERT INTO users (name, email) VALUES ('TrisTaam', '')")
            }
        }
    }
}