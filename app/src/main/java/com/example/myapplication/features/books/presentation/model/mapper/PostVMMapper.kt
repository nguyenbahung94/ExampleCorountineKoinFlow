package com.example.myapplication.features.books.presentation.model.mapper

import com.example.myapplication.core.mapper.Mapper
import com.example.myapplication.features.books.domain.model.PostEntity
import com.example.myapplication.features.books.presentation.model.PostVM

class PostVMMapper : Mapper<PostEntity, PostVM> {
    override fun map(origin: PostEntity) =
        PostVM(
            userId = origin.userId,
            id = origin.id,
            title = origin.title,
            body = origin.body
        )
}