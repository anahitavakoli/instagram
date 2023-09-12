package com.example.instagram.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagram.R
import com.example.instagram.databinding.FragmentHomeBinding
import com.example.instagram.models.Story
import com.example.instagram.util.Constants
import com.example.instagram.viewmodel.PostsViewModel


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
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
        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[PostsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listStory = mutableListOf<Story>()
        listStory.add(Story("Lena", R.drawable.lena))
        listStory.add(Story("Basir", R.drawable.basir))
        listStory.add(Story("Sohrab", R.drawable.sohrab))
        listStory.add(Story("Anna", R.drawable.anna))
        listStory.add(Story("Ebi", R.drawable.ebi))
     //   listStory.add(Story("Ebi", ${Constants.BASE_URL}story/maryam.jpg))

        binding.recyclerStory.adapter = StoryAdapter(requireContext(),listStory)
        binding.recyclerStory.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        viewModel.getPosts().observe(owner, Observer {
            binding.recyclerHomePosts.adapter = PostAdapter(it.post)
            binding.recyclerHomePosts.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        })
    }


}