package com.example.data.db.entity

import com.example.domain.entity.Post

fun Post.transformToPostDb() : PostDb {
    return PostDb(userId, id, title, body)
}

fun PostDb.transformToPost() : Post {
    return Post(userId, id, title, body)
}