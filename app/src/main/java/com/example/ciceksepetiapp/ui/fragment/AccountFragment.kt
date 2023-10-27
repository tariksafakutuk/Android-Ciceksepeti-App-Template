package com.example.ciceksepetiapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ciceksepetiapp.R
import com.example.ciceksepetiapp.data.entity.AccountCard
import com.example.ciceksepetiapp.databinding.FragmentAccountBinding
import com.example.ciceksepetiapp.ui.adapter.AccountCardAdapter

class AccountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white)

        binding = FragmentAccountBinding.inflate(inflater, container, false)

        binding.rvAccount.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        val accountCardList = createAccountCardList()
        val accountCardAdapter = AccountCardAdapter(requireContext(), accountCardList)

        binding.rvAccount.adapter = accountCardAdapter

        return binding.root
    }

    private fun createAccountCardList(): ArrayList<AccountCard>{
        val accountCardList = ArrayList<AccountCard>()
        val ac1 = AccountCard("account_login", "Üye Girişi")
        val ac2 = AccountCard("account_register", "Üye Ol")
        val ac3 = AccountCard("account_order_track", "Sipariş Takibi")
        val ac4 = AccountCard("account_notification", "Bildirimler")
        val ac5 = AccountCard("account_live_chat", "Canlı Destek")
        val ac6 = AccountCard("account_help", "Yardım")
        val ac7 = AccountCard("account_video_card", "VideoCard")
        val ac8 = AccountCard("account_campaign", "Kampanyalar")

        accountCardList.add(ac1)
        accountCardList.add(ac2)
        accountCardList.add(ac3)
        accountCardList.add(ac4)
        accountCardList.add(ac5)
        accountCardList.add(ac6)
        accountCardList.add(ac7)
        accountCardList.add(ac8)

        return accountCardList
    }
}