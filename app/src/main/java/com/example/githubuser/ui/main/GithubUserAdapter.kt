package com.example.githubuser.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.data.GithubUserData
import com.example.githubusers.databinding.ItemUserBinding

class GithubUserAdapter(
    private val onClick: (data: GithubUserData) -> Unit
) : ListAdapter<GithubUserData, GithubUserAdapter.GithubUserVHolder>(diffCallback) {

    private val onItemClicked = { data: GithubUserData ->
        onClick(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserVHolder {
        val binding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubUserVHolder(
            binding = binding,
            onClicked = onItemClicked
        )
    }

    override fun onBindViewHolder(holder: GithubUserVHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class GithubUserVHolder(
        private val binding: ItemUserBinding,
        private val onClicked: (data: GithubUserData) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: GithubUserData) {
            binding.apply {
                labelCurrency.text = data.name
                labelCurrencyAmount.text = data.name

                root.setOnClickListener {
                    onClicked(data)
                }
            }
        }
    }

}

val diffCallback = object : DiffUtil.ItemCallback<GithubUserData>() {
    override fun areItemsTheSame(oldItem: GithubUserData, newItem: GithubUserData) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GithubUserData, newItem: GithubUserData) =
        oldItem == newItem
}