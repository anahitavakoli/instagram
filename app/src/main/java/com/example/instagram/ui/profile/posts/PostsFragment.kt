package com.example.instagram.ui.profile.posts

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instagram.R
import com.example.instagram.databinding.FragmentPostsBinding
import com.example.instagram.viewmodel.PostsViewModel

class PostsFragment : Fragment() {

    lateinit var binding: FragmentPostsBinding
    lateinit var viewModel: PostsViewModel
    lateinit var owner: LifecycleOwner

    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(PostsViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref : SharedPreferences = requireActivity().getSharedPreferences("setting",Context.MODE_PRIVATE)
        val userId = pref.getString("id","")

        viewModel.getUserPost(userId!!,0,20).observe(owner, Observer {
            binding.recyclerUserPosts.adapter = UserPostsAdapter(it.post)
            binding.recyclerUserPosts.layoutManager = GridLayoutManager(requireContext(),3)
        })
    }

}