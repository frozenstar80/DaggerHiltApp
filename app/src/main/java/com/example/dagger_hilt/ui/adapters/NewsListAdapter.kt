package com.example.dagger_hilt.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dagger_hilt.databinding.ItemArticlePreviewBinding
import com.example.dagger_hilt.models.Article


class NewsListAdapter(
    private val list: MutableList<Article>,
    private val context: Context
) :
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {


    class NewsViewHolder(val binding: ItemArticlePreviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemArticlePreviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = list[position]
        with(holder) {
// set up data in Item File from the api call
            Glide.with(context).load(article.urlToImage).into(binding.ivArticleImage)
            binding.tvSource.text = article.source?.name
            binding.tvTitle.text = article.title
            binding.tvDescription.text = article.description
            binding.tvPublishedAt.text = article.publishedAt


    }
}

override fun getItemCount(): Int {
    return list.size

}}

