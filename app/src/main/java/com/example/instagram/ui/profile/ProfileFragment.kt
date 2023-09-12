package com.example.instagram.ui.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import coil.transform.CircleCropTransformation
import com.example.instagram.R
import com.example.instagram.databinding.FragmentProfileBinding
import com.example.instagram.models.Highlight
import com.example.instagram.ui.profile.posts.PostsFragment
import com.example.instagram.ui.profile.reels.VideosFragment
import com.example.instagram.util.Constants
import com.example.instagram.viewmodel.ProfileViewModel

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    lateinit var viewModel : ProfileViewModel
    lateinit var owner: LifecycleOwner

    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listHighlight = mutableListOf<Highlight>()
        listHighlight.add(Highlight("",R.drawable.lena))
        listHighlight.add(Highlight("",R.drawable.basir))
        listHighlight.add(Highlight("",R.drawable.sohrab))
        listHighlight.add(Highlight("",R.drawable.anna))
        listHighlight.add(Highlight("",R.drawable.ebi))
        //   listStory.add(Story("Ebi", ${Constants.BASE_URL}story/maryam.jpg))

        binding.recyclerHighlights.adapter = HighlightAdapter(requireContext(),listHighlight)
        binding.recyclerHighlights.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)

        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(PostsFragment(), "Posts")
        adapter.addFragment(VideosFragment(), "Reels")
        // Adding the Adapter to the ViewPager
        binding.viewPager.adapter = adapter
        // bind the viewPager with the TabLayout.
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        val pref : SharedPreferences = requireActivity().getSharedPreferences("setting",Context.MODE_PRIVATE)
        val userId = pref.getString("id","")

        binding.progressbar.visibility = View.VISIBLE

        viewModel.userProfile(userId!!)?.observe(owner, Observer {
            binding.progressbar.visibility = View.GONE
            binding.constraintProfile.visibility = View.VISIBLE

            binding.txtUsername.setText(it.username)
            binding.txtBio.setText(it.bio + "email: " + it.email)
            binding.imgProfile.load("${ Constants.BASE_URL}${it.image}"){
                transformations(CircleCropTransformation())
            }
        })
    }

}