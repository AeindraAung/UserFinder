package com.example.githubuser.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.R
import com.example.githubusers.databinding.MainFragmentBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {
    private val viewModel: MainViewModel by viewModels()

    private val binding by viewBinding(MainFragmentBinding::bind)

    private lateinit var userAdapter: GithubUserAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews() {
        userAdapter = GithubUserAdapter(
            onClick = {

            }
        )
        binding.rvCurrency.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }

        binding.refreshLayout.setOnRefreshListener {
            binding.refreshLayout.isRefreshing = true
            viewModel.getUserList()
        }

        viewModel.getUserList()
    }

    private fun initObservers() {
        viewModel.apply {
            userList.observe(viewLifecycleOwner) {
                userAdapter.submitList(it)
            }
        }
    }

}