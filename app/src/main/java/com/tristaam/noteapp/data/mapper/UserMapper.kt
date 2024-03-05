package com.tristaam.noteapp.data.mapper

import com.tristaam.noteapp.data.source.local.roomdb.entity.UserEntity
import com.tristaam.noteapp.domain.model.User

object UserMapper {
    fun toUserEntity(user: User): UserEntity {
        return UserEntity(
            id = user.id,
            name = user.name,
            email = user.email
        )
    }

    fun toUser(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            name = userEntity.name,
            email = userEntity.email
        )
    }
}