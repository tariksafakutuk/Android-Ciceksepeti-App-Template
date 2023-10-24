package com.example.ciceksepetiapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepetiapp.R
import com.example.ciceksepetiapp.databinding.HeaderCardBinding

class HeaderCardAdapter(
    private var mContext: Context,
    private var headerCardList: ArrayList<String>
) : RecyclerView.Adapter<HeaderCardAdapter.HeaderCardHolder>() {

    inner class HeaderCardHolder(var design: HeaderCardBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderCardHolder {
        val binding = HeaderCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return HeaderCardHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderCardHolder, position: Int) {
        val headerCard = headerCardList.get(position)
        val binding = holder.design

        binding.ivHeader.setImageResource(
            mContext.resources.getIdentifier(headerCard, "drawable", mContext.packageName)
        )

        binding.ivHeader.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homePageFragment_to_productListFragment)
        }

        binding.tvPageNumber.text = "${position + 1}/2"
    }

    override fun getItemCount(): Int {
        return headerCardList.size
    }
}