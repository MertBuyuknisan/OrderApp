package com.mertbuyuknisan.orderapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mertbuyuknisan.orderapp.data.entity.Yemekler
import com.mertbuyuknisan.orderapp.databinding.CardTasarimBinding
import com.mertbuyuknisan.orderapp.ui.fragment.AnasayfaFragmentDirections
import com.mertbuyuknisan.orderapp.ui.fragment.DetayFragment
import com.mertbuyuknisan.orderapp.ui.viewmodel.AnasayfaViewModel

class YemeklerAdapter(var mContext: Context, var yemeklerListesi: List<Yemekler>, var viewModel: AnasayfaViewModel): RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim= CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek=yemeklerListesi.get(position)
        val t =holder.tasarim
        t.textViewYemekAd.text=yemek.yemek_adi
        t.textViewYemekFiyat.text="${yemek.yemek_fiyat} ₺"
        val url="http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(300,300).into(t.imageViewYemekResim)

        t.addButton.setOnClickListener {
            val gecis= AnasayfaFragmentDirections.detayGecis(yemek = yemek)
            Navigation.findNavController(it).navigate(gecis)

        }

    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }



}