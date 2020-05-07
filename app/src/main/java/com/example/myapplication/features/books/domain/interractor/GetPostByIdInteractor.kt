package com.example.myapplication.features.books.domain.interractor

import com.example.myapplication.core.interactor.Interactor
import com.example.myapplication.features.books.domain.model.PostEntity
import com.example.myapplication.features.books.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostByIdInteractor(
    private val postRepository: PostRepository
) : Interactor<GetPostByIdInteractor.Params, Flow<PostEntity>> {

    override fun execute(params: Params): Flow<PostEntity> {
        return postRepository.getPostById(id = params.id)
    }

    data class Params(val id: String)
}