package com.example.myapplication.features.books.domain.repository

import com.example.myapplication.features.books.domain.model.PostEntity
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts(): Flow<PostEntity>
    fun getPostById(id: String): Flow<PostEntity>
}