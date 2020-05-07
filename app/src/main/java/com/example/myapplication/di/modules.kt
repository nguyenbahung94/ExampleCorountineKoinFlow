package com.example.myapplication.di

import com.example.myapplication.features.books.data.datasource.rest.PostRestDataStore
import com.example.myapplication.features.books.data.repository.PostRepositoryImpl
import com.example.myapplication.features.books.domain.interractor.GetPostByIdInteractor
import com.example.myapplication.features.books.domain.interractor.GetPostsInteractor
import com.example.myapplication.features.books.domain.repository.PostRepository
import com.example.myapplication.features.books.presentation.viewmodel.PostDetailViewModel
import com.example.myapplication.features.books.presentation.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val postModule = module {
    //region ViewModel
    viewModel {
        PostViewModel(get())
    }
    viewModel {
        PostDetailViewModel(get())
    }
    //endregion

    //region Interactor
    single {
        GetPostsInteractor(
            get()
        )
    }
    single {
        GetPostByIdInteractor(
            get()
        )
    }
    //endregion

    //region Repository
    single<PostRepository> {
        PostRepositoryImpl(get())
    }
    //endregion

    //region Datastore
    single {
        PostRestDataStore()
    }
    //endregion

}

val mModules = listOf(postModule)