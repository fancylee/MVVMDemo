package com.example.mvvmcomponentdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mvvmcomponentdemo.adapters.GardenPlantingAdapter
import com.example.mvvmcomponentdemo.databinding.FragmentGardenBinding

class GardenFragment :Fragment() {

    private lateinit var binding: FragmentGardenBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentGardenBinding.inflate(inflater, container, false)
        val adapter = GardenPlantingAdapter()
        binding.gardenList.adapter = adapter

//        binding.addPlant.setOnClickListener {
//            navigateToPlantListPage()
//        }
//
//        subscribeUi(adapter, binding)
        return binding.root
    }
}