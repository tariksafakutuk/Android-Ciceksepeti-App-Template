package com.example.ciceksepetiapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepetiapp.data.entity.AccountCard
import com.example.ciceksepetiapp.databinding.AccountCardBinding

class AccountCardAdapter(
    private var mContext: Context,
    private var accountCardList: List<AccountCard>
) : RecyclerView.Adapter<AccountCardAdapter.AccountCardHolder>() {

    inner class AccountCardHolder(var design: AccountCardBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountCardHolder {
        val binding = AccountCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return AccountCardHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountCardHolder, position: Int) {
        val accountCard = accountCardList.get(position)
        val binding = holder.design

        binding.ivCardIcon.setImageResource(
            mContext.resources.getIdentifier(accountCard.imageName, "drawable", mContext.packageName)
        )

        binding.tvCardText.text = accountCard.textName
    }

    override fun getItemCount(): Int {
        return accountCardList.size
    }
}