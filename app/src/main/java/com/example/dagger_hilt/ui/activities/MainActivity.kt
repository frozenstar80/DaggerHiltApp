package com.example.dagger_hilt.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger_hilt.databinding.ActivityMainBinding
import com.example.dagger_hilt.ui.adapters.NewsListAdapter
import com.example.dagger_hilt.ui.viewmodels.PostViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null
    private lateinit var newsAdapter: NewsListAdapter
    private val postViewModel:PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        // call method in viewModel  to get News and when livedata object get the result.
        //Result is passed to adapter to show in recycler View
        postViewModel.getPost()
        postViewModel.postLiveData.observe(this) {
            newsAdapter = NewsListAdapter(it.articles.toList().toMutableList(),this)
            binding!!.rvBreakingNews.apply {
                adapter = newsAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}