package com.example.ciceksepetiapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ciceksepetiapp.R
import com.example.ciceksepetiapp.databinding.FragmentHomePageBinding
import com.example.ciceksepetiapp.ui.adapter.ImageCardAdapter

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.header_background)

        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        binding.rvImageCard.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        val imageCardList = createImageCardList()

        val imageCardAdapter = ImageCardAdapter(requireContext(), imageCardList)
        binding.rvImageCard.adapter = imageCardAdapter

        return binding.root
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