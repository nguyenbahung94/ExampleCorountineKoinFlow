package com.example.myapplication.features.books.presentation.viewmodel.state

import com.example.myapplication.features.books.presentation.model.PostVM
import retrofit2.http.POST

sealed class PostVS {
    class AddPost(val postVM: PostVM) : PostVS()
    class Error(val message: String?) : PostVS()
}