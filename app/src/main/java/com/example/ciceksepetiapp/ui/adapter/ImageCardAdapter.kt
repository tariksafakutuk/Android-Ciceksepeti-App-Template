package com.example.ciceksepetiapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ciceksepetiapp.databinding.ImageCardBinding

class ImageCardAdapter(private var mContext: Context, private var imageCardList: List<String>) :
    RecyclerView.Adapter<ImageCardAdapter.ImageCardHolder>() {

    inner class ImageCardHolder(var design: ImageCardBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageCardHolder {
        val binding = ImageCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ImageCardHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageCardHolder, position: Int) {
        val imageCard = imageCardList.get(position)
        val binding = holder.design

        binding.ivCard.setImageResource(
            mContext.resources.getIdentifier(imageCard, "drawable", mContext.packageName)
        )
    }

    override fun getItemCount(): Int {
        return imageCardList.size
    }
}