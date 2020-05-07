package com.example.myapplication.features.books.presentation.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.features.books.presentation.adapter.RVPostAdapter
import com.example.myapplication.features.books.presentation.viewmodel.PostViewModel
import com.example.myapplication.features.books.presentation.viewmodel.state.PostVS
import kotlinx.android.synthetic.main.post_activity.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostActivity : AppCompatActivity(), RVPostAdapter.Listener {
    private val viewModel: PostViewModel by viewModel()
    private val mAdapter = RVPostAdapter()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post_activity)
        mAdapter.setListener(this)

        rvPost.apply {
            layoutManager = LinearLayoutManager(this@PostActivity)
            adapter = mAdapter
        }

        viewModel.viewState.observe(this@PostActivity, Observer {
            when (it) {
                is PostVS.AddPost -> {
                    mAdapter.add(it.postVM)
                }
                is PostVS.Error -> {
                    Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()

                }
            }
        })
        viewModel.getPosts()
    }

    override fun onPostClicked(id: Int) {
        Toast.makeText(this, "Click at $id", Toast.LENGTH_SHORT).show()
        PostDetailActivity.open(this, id.toString())
    }
}