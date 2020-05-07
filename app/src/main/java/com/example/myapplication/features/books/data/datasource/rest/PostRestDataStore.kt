package com.example.myapplication.features.books.data.datasource.rest

import com.example.myapplication.features.books.data.datasource.rest.response.PostResponseData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostRestDataStore {

    fun getPots(): Flow<PostResponseData> = flow {
        PostApiClient.getApiClient().getPost().forEach {
            emit(it)
        }
    }

    fun getPostById(id: String): Flow<PostResponseData> = flow {
        emit(PostApiClient.getApiClient().getPostById(id = id))
    }
}