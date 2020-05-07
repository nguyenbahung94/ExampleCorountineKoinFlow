package com.example.myapplication.features.books.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.interactor.Interactor
import com.example.myapplication.core.platform.BaseViewModel
import com.example.myapplication.core.utils.io
import com.example.myapplication.core.utils.ui
import com.example.myapplication.features.books.domain.interractor.GetPostsInteractor
import com.example.myapplication.features.books.presentation.model.mapper.PostVMMapper
import com.example.myapplication.features.books.presentation.viewmodel.state.PostVS
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel(
    private val getPostsInteractor: GetPostsInteractor
) : BaseViewModel() {
    private val mViewState = MutableLiveData<PostVS>()
    val viewState: LiveData<PostVS> get() = mViewState

    private val mPostVMMapper by lazy { PostVMMapper() }

    fun getPosts() {
        viewModelScope.launch {
            try {
                io {
                    getPostsInteractor.execute(Interactor.None)
                        .collect {
                            ui { mViewState.value = PostVS.AddPost(mPostVMMapper.map(it)) }
                        }
                }

            } catch (e: Exception) {
                ui { mViewState.value = PostVS.Error(e.message) }
            }
        }
    }
}