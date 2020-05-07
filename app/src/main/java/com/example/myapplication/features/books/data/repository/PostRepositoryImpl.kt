package com.example.myapplication.features.books.data.repository

import com.example.myapplication.features.books.data.datasource.rest.PostRestDataStore
import com.example.myapplication.features.books.data.mapper.PostDataMapper
import com.example.myapplication.features.books.domain.model.PostEntity
import com.example.myapplication.features.books.domain.repository.PostRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

class PostRepositoryImpl(
    private val postRestDataStore: PostRestDataStore
) : PostRepository {
    private val mPostDataMapper by lazy { PostDataMapper() }

    override fun getPosts(): Flow<PostEntity> =
        postRestDataStore.getPots().map {
            mPostDataMapper.map(it)
        }


    @ExperimentalCoroutinesApi
    override fun getPostById(id: String): Flow<PostEntity> =
        postRestDataStore.getPostById(id = id).map {
            mPostDataMapper.map(it)
        }
}