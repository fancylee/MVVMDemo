package com.example.mvvmcomponentdemo.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1
class SunflowerPagerAdapter(fragment:Fragment) :FragmentStateAdapter(fragment) {

    val tabFragmentsCreators:Map<Int,()->Fragment> = mapOf(
            MY_GARDEN_PAGE_INDEX to { },
            PLANT_LIST_PAGE_INDEX to { }
    )
    override fun getItemCount(): Int {

    }

    override fun createFragment(position: Int): Fragment {
    }
}