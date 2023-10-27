package com.example.ciceksepetiapp.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepetiapp.data.entity.Product
import com.example.ciceksepetiapp.databinding.ProductCardBinding

class ProductAdapter(private var mContext: Context, private var productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    inner class ProductHolder(var design: ProductCardBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val binding = ProductCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = productList.get(position)
        val binding = holder.design

        binding.ivProduct.setImageResource(
            mContext.resources.getIdentifier(product.imageName, "drawable", mContext.packageName)
        )

        binding.tvProductName.text = product.productName
        binding.tvStarRate.text = product.starRate
        binding.tvNewPrice.text = product.newPrice
        binding.tvOldPrice.text = product.oldPrice
        binding.tvOldPriceRate.text = product.oldPriceRate

        binding.tvOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}