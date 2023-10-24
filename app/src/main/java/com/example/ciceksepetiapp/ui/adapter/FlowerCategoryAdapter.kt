package com.example.ciceksepetiapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepetiapp.R
import com.example.ciceksepetiapp.data.entity.FlowerCategory
import com.example.ciceksepetiapp.databinding.FlowerCategoryCardBinding

class FlowerCategoryAdapter(
    private var mContext: Context,
    private var flowerCategoryList: List<FlowerCategory>
) : RecyclerView.Adapter<FlowerCategoryAdapter.FlowerCategoryCardHolder>() {

    inner class FlowerCategoryCardHolder(var design: FlowerCategoryCardBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerCategoryCardHolder {
        val binding = FlowerCategoryCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return FlowerCategoryCardHolder(binding)
    }

    override fun onBindViewHolder(holder: FlowerCategoryCardHolder, position: Int) {
        val flowerCategory = flowerCategoryList.get(position)
        val binding = holder.design

        binding.ivFlowerCategory.setImageResource(
            mContext.resources.getIdentifier(flowerCategory.imageName, "drawable", mContext.packageName)
        )

        binding.ivFlowerCategory.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homePageFragment_to_productListFragment)
        }

        binding.tvFlowerCategory.text = flowerCategory.categoryName
    }

    override fun getItemCount(): Int {
        return flowerCategoryList.size
    }
}