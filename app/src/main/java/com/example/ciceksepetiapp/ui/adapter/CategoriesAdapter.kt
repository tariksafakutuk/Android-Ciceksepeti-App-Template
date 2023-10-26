package com.example.ciceksepetiapp.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepetiapp.R
import com.example.ciceksepetiapp.data.entity.FlowerCategory
import com.example.ciceksepetiapp.databinding.CategoryCardBinding
import org.w3c.dom.Text

class CategoriesAdapter(
    private var mContext: Context,
    private var categoryList: List<FlowerCategory>,
    private var tvTitle: TextView,
    private var listView: ListView
) : RecyclerView.Adapter<CategoriesAdapter.CategoryHolder>() {
    private val bindingList = ArrayList<CategoryCardBinding>()

    inner class CategoryHolder(var design: CategoryCardBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val binding = CategoryCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CategoryHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val category = categoryList.get(position)
        val binding = holder.design

        if (position == 0) {
            binding.linearLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white))
            binding.ivCategory.setColorFilter(ContextCompat.getColor(mContext, R.color.category_item_selected))
            binding.tvCategory.setTextColor(ContextCompat.getColor(mContext, R.color.category_item_selected))

            addItemToListView(position)
        } else {
            binding.linearLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.category_background))
            binding.ivCategory.setColorFilter(ContextCompat.getColor(mContext, R.color.category_item_default))
            binding.tvCategory.setTextColor(ContextCompat.getColor(mContext, R.color.category_item_default))
        }

        bindingList.add(binding)

        binding.ivCategory.setImageResource(
            mContext.resources.getIdentifier(category.imageName, "drawable", mContext.packageName)
        )

        binding.tvCategory.text = category.categoryName

        binding.linearLayout.setOnClickListener {
            binding.linearLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white))

            binding.ivCategory.setColorFilter(ContextCompat.getColor(mContext, R.color.category_item_selected))

            binding.tvCategory.setTextColor(ContextCompat.getColor(mContext, R.color.category_item_selected))

            setCategoryBackground(position)
            addItemToListView(position)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    private fun setCategoryBackground(position: Int) {
        bindingList.forEach {
            if (it != bindingList.get(position)) {
                it.linearLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.category_background))
                it.ivCategory.setColorFilter(ContextCompat.getColor(mContext, R.color.category_item_default))
                it.tvCategory.setTextColor(ContextCompat.getColor(mContext, R.color.category_item_default))
            }
        }
    }

    private fun addItemToListView(position: Int) {
        val arrayAdapter: ArrayAdapter<*>
        var users = ArrayList<String>()
        when (position) {
            0 -> {
                tvTitle.text = "Çiçek"
                users = arrayListOf(
                    "Tüm Ürünleri Gör", "Saksı Çiçekleri", "Çiçek Buketleri", "Güller", "Viabonte Taze Çiçekler",
                    "Orkide", "Papatya & Gerbera", "Yenilebilir Çiçek", "Çiçek & Hediye", "Çelenkler",
                    "Lityum & Zambak", "Kişiye Özel Çiçekler", "Renge Göre Çiçekler", "Kutuda Güller", "Bonsai",
                    "Lavanta", "Ferforje"
                )
            }

            1 -> {
                tvTitle.text = "Yenilebilir Çiçek"
                users = arrayListOf(
                    "Tüm Ürünleri Gör","Kek & Kurabiye Buketi", "Doğum Günü", "Gurme Lezzetler", "Çikolata",
                    "Sevgili", "Yeni İş/Terfi", "İçimden Geldi", "Geçmiş Olsun", "Kişiye Özel",
                    "Yeni Bebek", "Arkadaşa", "Bebek Çikolataları", "Özür Dilerim", "Yıl Dönümü",
                    "Kalpli Aranjmanlar", "Söz Nişan Çikolatası", "Doğum Günü Çikolatası"
                )
            }

            2 -> {
                tvTitle.text = "Çikolata"
                users = arrayListOf(
                    "Tüm Ürünleri Gör", "Doğum Günü Çikolatası", "Söz Nişan Çikolatası", "İsteme Çikolatası", "Bebek Çikolatası",
                    "Anneye Çikolata", "Babaya Çikolata", "Sevgiliye Çikolata", "Geçmiş Olsun Çikolatası", "Kişiye Özel Çikolata",
                    "Trüf Çikolata"
                )
            }

            3 -> {
                tvTitle.text = "Doğum Günü"
                users = arrayListOf(
                    "Tüm Ürünleri Gör", "Doğum Günü Hediyeleri", "Kadına Hediye", "Erkeğe Hediye", "Saat Ve Aksesuarları",
                    "Doğum Günü Çiçekleri", "Kişiye Özel", "Erkek Aksesuar", "Fotoğraflı Ürünler", "Çocuğa Hediye",
                    "Doğum Günü Bonnyfood", "Çikolata", "Kadın Saat", "Takı & Aksesuar", "Tasarım Çiçekler",
                    "Kişiye Özel Çiçekler", "Saksı Çiçekleri", "Bonsai", "Dini Hediyeler", "Babaya Hediye",
                    "Güller"
                )
            }

            4 -> {
                tvTitle.text = "Gönderim Amacı"
                users = arrayListOf(
                    "Tüm Ürünleri Gör", "Doğum Günü", "Yeni İş/Terfi", "Geçmiş Olsun", "Yeni Bebek",
                    "Yıl Dönümü", "Söz/Nişan/Düğün", "Özür Dilerim", "İçimden Geldi", "Sevgili",
                    "Açılış/Tören", "Tebrik", "Cenaze", "Kendim İçin"
                )
            }

            5 -> {
                tvTitle.text = "Orkide / Saksı Çiçekleri"
                users = arrayListOf(
                    "Tüm Ürünleri Gör", "Orkide", "Barış Çiçeği", "Antoryum", "Sukulent",
                    "Kaktüs", "Zeytin Ağacı", "Bonsai", "Kalanchoe", "Howarthia",
                    "Şeflera", "Guzmanya", "Tillandsia"
                )
            }

            6 -> {
                tvTitle.text = "Viabonte Taze Çiçekler"
                users = arrayListOf(
                    "Tüm Ürünleri Gör", "Saksı Bitkileri", "Premium Çiçekler", "Buket Çiçekler", "Lilyum",
                    "Mesajlı Çiçekler", "Papatya & Gerbera", "Güller", "Dekoratif Çiçekler", "Doğum Günü",
                    "Kutuda Güller", "Sevgili", "Yeni İş/Terfi", "Butik Güller", "Orkide"
                )
            }

            7 -> {
                tvTitle.text = "Gurme Lezzetler"
                users = arrayListOf(
                    "Tüm Ürünleri Gör", "Bonnyfood Gurme Serisi", "Gurme Kek & Kurabiye", "Doğum Günü", "Sevgili",
                    "Geçmiş Olsun", "Lotuslu Lezzetler", "Oreolu Lezzetler", "Kitkatlı Lezzetler"
                )
            }

            8 -> {
                tvTitle.text = "Hediye"
                users = arrayListOf(
                    "Tüm Ürünleri Gör", "Doğum Günü", "Kadına Hediye", "Kişiye Özel", "Takı/Aksesuar",
                    "Erkeğe Hediye", "Aynı Gün Teslim", "Sevgiliye Hediye", "Saat", "Yeni İş/Terfi",
                    "Oyuncak", "Yeni Bebek", "Hediye Kutusu", "Erkek Aksesuarları", "Kupa Bardaklar",
                    "Ayıcık", "Kendin Tasarla", "Ofis, Kırtasiye", "Fotoğraflı Ürünler", "Parfüm",
                    "Yıl Dönümü", "İçimden Geldi", "Kolye", "Ev Hediyesi", "Hediye Setleri",
                    "Dekoratif Ürünler", "Kar Küresi", "Çocuğa Hediye", "Çakmak", "Nostaljik Hediyeler",
                    "Termos", "Spotify Plak", "Peluş Oyuncaklar", "Özür Dilerim", "Tablo",
                    "Cüzdan", "Kalem", "Gece Lambası", "Müzik Kutusu - Kar Küresi", "Kokulu Taşlar",
                    "Dini Hediyeler", "Bebek Ürünleri", "Babaya Hediye", "Kişiye Özel Elektronik", "Dijital Hediyeler",
                    "Kitap", "Puzzle"
                )
            }

            9 -> {
                tvTitle.text = "Kişiye Özel"
                users = arrayListOf(
                    "Tüm Ürünleri Gör", "Fotoğraflı Ürünler", "Hediye", "Kendin Tasarla", "Hediye Setleri",
                    "Kupa", "Hediye Kutusu", "Ofis & Kırtasiye", "Takı, Saat, Aksesuar", "Dekoratif Ürünler",
                    "Çiçek", "Telefon Kılıfı", "Karikatür Biblo", "Kolye", "Çakmak",
                    "Tişört", "Spotify Plak", "Kar Küresi", "Bileklik", "Anahtarlık",
                    "Cüzdan", "Tablo", "İsimlik", "Peluş Oyuncak", "Led Lamba",
                    "Aksesuar", "Çikolata", "Termos", "Kalem", "Karikatürlü Ürünler",
                    "Viski Bardağı, Taşı", "Bebek Ürünleri", "Elektronik Ürünler", "Kol Saati", "Spotify Aksesuarlar",
                    "Dini Hediyeler", "Yastık", "Ajanda", "Rakı Bardağı", "Oyun, Oyuncak",
                    "Tespih", "Defter", "Cep Saati", "Kol Düğmesi", "Yenilebilir Çiçek"
                )
            }

            10 -> {
                tvTitle.text = "Hediye Setleri"
                users = arrayListOf(
                    "Tüm Ürünleri Gör", "Anneye Özel", "Kadınlara Özel", "Kişiye Özel", "Sevgiliye Özel",
                    "Erkekler İçin", "Ofis-Kırtasiye Setleri", "Kahveli Setler", "Peluşlu Setler", "Nostaljik Setler",
                    "Kupa-Termoslu Setler", "Anne-Bebek Konsepti", "Kitaplı Setler", "Dini Temalı Setler"
                )
            }
        }

        arrayAdapter = ArrayAdapter(mContext,R.layout.list_view_item, users)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener{ parent, view, pos, id ->
            Navigation.findNavController(view).navigate(R.id.action_categoriesFragment_to_productListFragment)
        }
    }
}