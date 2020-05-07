package com.example.myapplication.features.books.domain.interractor

import com.example.myapplication.core.interactor.Interactor
import com.example.myapplication.features.books.domain.model.PostEntity
import com.example.myapplication.features.books.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostsInteractor(private val postRepository: PostRepository) :
    Interactor<Interactor.None, Flow<PostEntity>> {

    override fun execute(params: Interactor.None): Flow<PostEntity> {
        return postRepository.getPosts()
    }
}