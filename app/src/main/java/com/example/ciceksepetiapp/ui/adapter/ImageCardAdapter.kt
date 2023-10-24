package com.example.ciceksepetiapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ciceksepetiapp.R
import com.example.ciceksepetiapp.data.entity.FlowerCategory
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

        when (position) {
            0 -> {
                binding.rvFlowerCategory.visibility = View.VISIBLE
                binding.rvFlowerCategory.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

                val flowerCategoryList = createFlowerCategoryList()

                val flowerCategoryAdapter = FlowerCategoryAdapter(mContext, flowerCategoryList)
                binding.rvFlowerCategory.adapter = flowerCategoryAdapter

                binding.rvImageCard.visibility = View.VISIBLE
                binding.rvImageCard.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

                val headerCardList = createHeaderCardList()

                val headerCardAdapter = HeaderCardAdapter(mContext, headerCardList)
                binding.rvImageCard.adapter = headerCardAdapter
            }
            imageCardList.size - 1 -> {
                binding.buttonCategory.visibility = View.VISIBLE
                binding.buttonCategory.setOnClickListener {
                    Navigation.findNavController(it).navigate(R.id.action_homePageFragment_to_categoriesFragment)
                }
            }
            else -> {
                binding.rvFlowerCategory.visibility = View.GONE
                binding.rvImageCard.visibility = View.GONE
                binding.buttonCategory.visibility = View.GONE
            }
        }

        binding.ivCard.setImageResource(
            mContext.resources.getIdentifier(imageCard, "drawable", mContext.packageName)
        )

        binding.ivCard.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homePageFragment_to_productListFragment)
        }
    }

    override fun getItemCount(): Int {
        return imageCardList.size
    }

    private fun createFlowerCategoryList() : ArrayList<FlowerCategory> {
        val flowerCategoryList = ArrayList<FlowerCategory>()
        val fc1 = FlowerCategory("flower_category_1", "Doğum Günü Çiçekleri")
        val fc2 = FlowerCategory("flower_category_2", "Yıldönümü Çiçekleri")
        val fc3 = FlowerCategory("flower_category_3", "Aynı Gün Çiçek")
        val fc4 = FlowerCategory("flower_category_4", "Leziz Çikolatalar")
        val fc5 = FlowerCategory("flower_category_5", "İçimden Geldi")
        val fc6 = FlowerCategory("flower_category_6", "Güller")
        val fc7 = FlowerCategory("flower_category_7", "Özür Çiçekleri")
        val fc8 = FlowerCategory("flower_category_8", "Yeni Bebek Çiçekleri")
        val fc9 = FlowerCategory("flower_category_9", "Lotuslu Lezzetler")
        val fc10 = FlowerCategory("flower_category_10", "Çiçek & Hediyeler")
        val fc11 = FlowerCategory("flower_category_11", "Mevsim Çiçekleri")
        val fc12 = FlowerCategory("flower_category_12", "Lavanta")
        val fc13 = FlowerCategory("flower_category_13", "Yenilebilir Çiçek")

        flowerCategoryList.add(fc1)
        flowerCategoryList.add(fc2)
        flowerCategoryList.add(fc3)
        flowerCategoryList.add(fc4)
        flowerCategoryList.add(fc5)
        flowerCategoryList.add(fc6)
        flowerCategoryList.add(fc7)
        flowerCategoryList.add(fc8)
        flowerCategoryList.add(fc9)
        flowerCategoryList.add(fc10)
        flowerCategoryList.add(fc11)
        flowerCategoryList.add(fc12)
        flowerCategoryList.add(fc13)

        return flowerCategoryList
    }

    private fun createHeaderCardList(): ArrayList<String> {
        val headerCardList = ArrayList<String>()
        headerCardList.add("header_card_image_1")
        headerCardList.add("header_card_image_2")

        return headerCardList
    }
}