package com.example.mvvmcomponentdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcomponentdemo.R
import com.example.mvvmcomponentdemo.data.PlantAndGardenPlantings
import com.example.mvvmcomponentdemo.databinding.ListItemGardenPlantingBinding
import com.example.mvvmcomponentdemo.viewmodels.PlantAndGardenPlantingsViewModel

class GardenPlantingAdapter : ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder>(
        GardenPlantDiffCallback()
) {


    class ViewHolder(val binding: ListItemGardenPlantingBinding) :RecyclerView.ViewHolder(binding.root){

        init {
            binding.setClickListener { view ->

                binding.viewModel.plantId.let {
                    plantId ->

                }
            }

        }
//        private fun navigateToPlant(plantId: String, view: View) {
//            val direction = HomeViewPagerFragmentDirections
//                    .actionViewPagerFragmentToPlantDetailFragment(plantId)
//            view.findNavController().navigate(direction)
//        }

        fun bind(plantings:PlantAndGardenPlantings){
            with(binding){
                viewModel = PlantAndGardenPlantingsViewModel(plantings)
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item_garden_planting,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class GardenPlantDiffCallback : DiffUtil.ItemCallback<PlantAndGardenPlantings>() {
    override fun areItemsTheSame(oldItem: PlantAndGardenPlantings, newItem: PlantAndGardenPlantings): Boolean {
        return oldItem.plant.plantId == newItem.plant.plantId
    }

    override fun areContentsTheSame(oldItem: PlantAndGardenPlantings, newItem: PlantAndGardenPlantings): Boolean {
        return oldItem.plant == newItem.plant
    }

}