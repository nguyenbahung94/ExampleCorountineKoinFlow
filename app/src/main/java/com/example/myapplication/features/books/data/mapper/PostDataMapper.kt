package com.example.myapplication.features.books.data.mapper

import com.example.myapplication.core.mapper.Mapper
import com.example.myapplication.features.books.data.datasource.rest.response.PostResponseData
import com.example.myapplication.features.books.domain.model.PostEntity

class PostDataMapper : Mapper<PostResponseData, PostEntity> {
    override fun map(origin: PostResponseData): PostEntity = PostEntity(
        userId = origin.userId,
        id = origin.id,
        title = origin.title,
        body = origin.body
    )

}