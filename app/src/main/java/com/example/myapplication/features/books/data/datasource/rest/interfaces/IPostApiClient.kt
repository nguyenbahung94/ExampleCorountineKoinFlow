package com.example.myapplication.features.books.data.datasource.rest.interfaces

import com.example.myapplication.features.books.data.datasource.rest.response.PostResponseData
import retrofit2.http.GET
import retrofit2.http.Path

interface IPostApiClient {

    @GET("/posts")
    suspend fun getPost(): List<PostResponseData>

    @GET("/posts/{id}")
    suspend fun getPostById(@Path("id") id: String): PostResponseData
}