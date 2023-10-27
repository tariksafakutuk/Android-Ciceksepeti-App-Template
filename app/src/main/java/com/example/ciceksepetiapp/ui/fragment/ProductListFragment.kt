package com.example.ciceksepetiapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ciceksepetiapp.R
import com.example.ciceksepetiapp.data.entity.Product
import com.example.ciceksepetiapp.databinding.FragmentProductListBinding
import com.example.ciceksepetiapp.ui.adapter.ProductAdapter

class ProductListFragment : Fragment() {
    private lateinit var binding: FragmentProductListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white)

        binding = FragmentProductListBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.rvProduct.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val productList = createProductList()
        val productAdapter = ProductAdapter(requireContext(), productList)

        binding.rvProduct.adapter = productAdapter

        return binding.root
    }

    private fun createProductList(): ArrayList<Product> {
        val productList = ArrayList<Product>()
        val p1 = Product("product_1", "Paşabahçe Akvaryum Vazoda 7 Kırmızı Gül", "4,4 (99999+)", "249,00 TL", "299,00 TL", "%17")
        val p2 = Product("product_2", "Atatürk Çiçeği - Midi Ponsetya", "4,4 (6772)", "249,00 TL", "299,00 TL", "%17")
        val p3 = Product("product_3", "Aşkın Mevsimi Kürede Lisyantus Aranjmanı", "4,4 (24616)", "249,00 TL", "299,00 TL", "%17")
        val p4 = Product("product_4", "11'li Kırmızı Gül Çiçek Buketi", "4,3 (26190)", "299,00 TL", "329,00 TL", "%9")
        val p5 = Product("product_5", "Kucak Dolusu Aşk 25 Kırmızı Gül Buketi", "4,2 (18028)", "499,00 TL", "599,00 TL", "%17")
        val p6 = Product("product_6", "Paşabahçe Vazoda 15'li Kırmızı Gül", "4,4 (15524)", "349,00 TL", "399,00 TL", "%13")
        val p7 = Product("product_7", "Paşabahçe Vazoda 9'lu Kırmızı Gül", "4,5 (10275)", "269,00 TL", "319,00 TL", "%16")
        val p8 = Product("product_8", "ViaBonte-Sun Came Up", "4,4 (2367)", "329,00 TL", "379,00 TL", "%13")

        productList.add(p1)
        productList.add(p2)
        productList.add(p3)
        productList.add(p4)
        productList.add(p5)
        productList.add(p6)
        productList.add(p7)
        productList.add(p8)

        return productList
    }
}