package com.example.ciceksepetiapp.ui.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ciceksepetiapp.data.entity.FlowerCategory
import com.example.ciceksepetiapp.databinding.FragmentCategoriesBinding
import com.example.ciceksepetiapp.ui.adapter.CategoriesAdapter

class CategoriesFragment : Fragment() {
    private lateinit var binding: FragmentCategoriesBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        binding.rvCategories.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        val categoryList = createCategoryCardList()
        val categoriesAdapter = CategoriesAdapter(requireContext(), categoryList, binding.tvTitle, binding.listViewCategories)

        binding.rvCategories.adapter = categoriesAdapter

        return binding.root
    }

    private fun createCategoryCardList(): ArrayList<FlowerCategory> {
        val categoryList = ArrayList<FlowerCategory>()
        val c1 = FlowerCategory("category_flower", "Çiçek")
        val c2 = FlowerCategory("category_bunnyfood", "Yenilebilir Çiçek")
        val c3 = FlowerCategory("category_chocolate", "Çikolata")
        val c4 = FlowerCategory("category_birthday", "Doğum Günü")
        val c5 = FlowerCategory("category_purpose", "Gönderim Amacı")
        val c6 = FlowerCategory("category_orchid", "Orkide / Saksı Çiçekleri")
        val c7 = FlowerCategory("category_viabonte", "Viabonte Taze Çiçekler")
        val c8 = FlowerCategory("category_gourmet", "Gurme Lezzetler")
        val c9 = FlowerCategory("category_gift", "Hediye")
        val c10 = FlowerCategory("category_personal", "Kişiye Özel")
        val c11 = FlowerCategory("category_gift_sets", "Hediye Setleri")

        categoryList.add(c1)
        categoryList.add(c2)
        categoryList.add(c3)
        categoryList.add(c4)
        categoryList.add(c5)
        categoryList.add(c6)
        categoryList.add(c7)
        categoryList.add(c8)
        categoryList.add(c9)
        categoryList.add(c10)
        categoryList.add(c11)

        return categoryList
    }
}