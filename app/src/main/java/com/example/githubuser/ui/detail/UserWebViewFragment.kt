package com.example.githubuser.ui.detail

import androidx.fragment.app.Fragment
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentWebviewBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserWebViewFragment: Fragment(R.layout.fragment_webview) {
    private val binding by viewBinding(FragmentWebviewBinding::bind)
}