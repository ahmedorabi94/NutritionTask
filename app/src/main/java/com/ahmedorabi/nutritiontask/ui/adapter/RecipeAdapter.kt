package com.ahmedorabi.nutritiontask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmedorabi.nutritiontask.data.model.Parsed
import com.ahmedorabi.nutritiontask.databinding.UserItemBinding
import com.ahmedorabi.nutritiontask.ui.ingredientlist.IngredientListViewModel

class RecipeAdapter(private val callback: RecipeCallback, private val viewModel: IngredientListViewModel) :
    ListAdapter<Parsed, RecipeAdapter.MyViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<Parsed>() {
        override fun areItemsTheSame(oldItem: Parsed, newItem: Parsed): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Parsed, newItem: Parsed): Boolean {
            return oldItem.food == newItem.food
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.callback = callback
        binding.viewmodel = viewModel
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class MyViewHolder(private var binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Parsed) {
            binding.item = item
        }

    }


}