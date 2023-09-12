package com.example.instagram.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.instagram.R
import com.example.instagram.databinding.FragmentDashboardBinding
import com.example.instagram.ui.addPost.AddPostFragment
import com.example.instagram.ui.explore.ExploreFragment
import com.example.instagram.ui.home.HomeFragment
import com.example.instagram.ui.profile.ProfileFragment


class DashboardFragment : Fragment() {

    lateinit var binding : FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var fragmentList = mutableListOf<Fragment>()
        fragmentList.add(HomeFragment())
        fragmentList.add(ExploreFragment())
        fragmentList.add(AddPostFragment())
        fragmentList.add(ProfileFragment())

        binding.fragmentViewPager.adapter = PagerAdapter(requireActivity(),fragmentList)
        binding.fragmentViewPager.isUserInputEnabled = false

        binding.bottomNavigationMenu.setOnItemSelectedListener {

            when(it.itemId){
                R.id.item_home -> {
                    binding.fragmentViewPager.currentItem = 0
                    true
                }
                R.id.item_explore -> {
                    binding.fragmentViewPager.currentItem = 1
                    true
                }
                R.id.item_add_post -> {
                    binding.fragmentViewPager.currentItem = 2
                    true
                }
                R.id.item_profile -> {
                    binding.fragmentViewPager.currentItem = 3
                    true
                }
                else -> {
                    true
                }
            }
        }

        binding.fragmentViewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when(position){
                    0 -> binding.bottomNavigationMenu.menu.findItem(R.id.item_home).setChecked(true)
                    1 -> binding.bottomNavigationMenu.menu.findItem(R.id.item_explore).setChecked(true)
                    2 -> binding.bottomNavigationMenu.menu.findItem(R.id.item_add_post).setChecked(true)
                    3 -> binding.bottomNavigationMenu.menu.findItem(R.id.item_profile).setChecked(true)
                }
            }
        })

    }


}
