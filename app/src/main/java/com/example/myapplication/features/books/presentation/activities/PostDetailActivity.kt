package com.example.myapplication.features.books.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.features.books.presentation.model.PostVM
import com.example.myapplication.features.books.presentation.viewmodel.PostDetailViewModel
import com.example.myapplication.features.books.presentation.viewmodel.state.PostVS
import kotlinx.android.synthetic.main.post_detail_activity.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostDetailActivity : AppCompatActivity() {
    private val viewModel: PostDetailViewModel by viewModel()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post_detail_activity)
        viewModel.viewState.observe(this@PostDetailActivity, Observer {
            when (it) {
                is PostVS.AddPost -> {
                    updateUI(it.postVM)
                }
                is PostVS.Error -> {
                    Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()

                }
            }
        })

        viewModel.getPostDetail(intent.getStringExtra("id")!!)
    }

    private fun updateUI(postVM: PostVM) {
        tvUser.text = postVM.userId.toString()
        tvTitle.text = postVM.title.toString()
        tvBody.text = postVM.body.toString()
    }

    companion object {
        fun open(context: Context, id: String) {
            val intent = Intent(context, PostDetailActivity::class.java)
            intent.putExtra("id", id)
            context.startActivity(intent)
        }
    }

}