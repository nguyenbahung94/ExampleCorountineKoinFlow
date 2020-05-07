package com.example.myapplication.features.books.data.datasource.rest

import com.example.myapplication.core.network.BaseApiClient
import com.example.myapplication.features.books.data.datasource.rest.interfaces.IPostApiClient

object PostApiClient : BaseApiClient<IPostApiClient>(IPostApiClient::class.java)
