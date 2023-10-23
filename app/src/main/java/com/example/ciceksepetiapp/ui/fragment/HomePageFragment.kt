package com.example.ciceksepetiapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ciceksepetiapp.data.entity.FlowerCategory
import com.example.ciceksepetiapp.databinding.FragmentHomePageBinding
import com.example.ciceksepetiapp.ui.adapter.FlowerCategoryAdapter
import com.example.ciceksepetiapp.ui.adapter.HeaderCardAdapter
import com.example.ciceksepetiapp.ui.adapter.ImageCardAdapter

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        binding.rvFlowerCategory.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        val flowerCategoryList = createFlowerCategoryList()

        val flowerCategoryAdapter = FlowerCategoryAdapter(requireContext(), flowerCategoryList)
        binding.rvFlowerCategory.adapter = flowerCategoryAdapter

        binding.rvHeaderCard.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        val headerCardList = createHeaderCardList()

        val headerCardAdapter = HeaderCardAdapter(requireContext(), headerCardList)
        binding.rvHeaderCard.adapter = headerCardAdapter

        binding.rvImageCard.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        val imageCardList = createImageCardList()

        val imageCardAdapter = ImageCardAdapter(requireContext(), imageCardList)
        binding.rvImageCard.adapter = imageCardAdapter

        return binding.root
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

    private fun createImageCardList() : ArrayList<String> {
        val imageCardList = ArrayList<String>()
        imageCardList.add("image_card_1")
        imageCardList.add("image_card_2")
        imageCardList.add("image_card_3")
        imageCardList.add("image_card_4")
        imageCardList.add("image_card_5")
        imageCardList.add("image_card_6")
        imageCardList.add("image_card_7")
        imageCardList.add("image_card_8")
        imageCardList.add("image_card_9")
        imageCardList.add("image_card_10")
        imageCardList.add("image_card_11")
        imageCardList.add("image_card_12")
        imageCardList.add("image_card_13")
        imageCardList.add("image_card_14")
        imageCardList.add("image_card_15")
        imageCardList.add("image_card_16")
        imageCardList.add("image_card_17")
        imageCardList.add("image_card_18")
        imageCardList.add("image_card_19")

        return imageCardList
    }
}