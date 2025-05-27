package com.mertbuyuknisan.orderapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mertbuyuknisan.orderapp.data.entity.Sepetler
import com.mertbuyuknisan.orderapp.data.entity.Yemekler
import com.mertbuyuknisan.orderapp.databinding.CardTasarimSepetBinding
import com.mertbuyuknisan.orderapp.retrofit.YemeklerDao
import com.mertbuyuknisan.orderapp.ui.viewmodel.SepetViewModel

class SepetAdapter(var mContext: Context,var sepetListesi: List<Sepetler>,var viewModel: SepetViewModel):RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardTasarimSepetBinding) :
        RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): CardTasarimTutucu {
        val tasarim=CardTasarimSepetBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val sepet=sepetListesi.get(position)

        val t=holder.tasarim

            t.textViewYemekAdiSepet.text=sepet.yemek_adi
            t.textViewYemekAdetSepet.text="Adet: ${sepet.yemek_siparis_adet}"
            t.textViewToplamTutarSepet.text="Toplam Tutar: ${sepet.yemek_siparis_adet*sepet.yemek_fiyat} ₺"
            t.textViewYemekFiyatAdet.text="Fiyat(Adet): ${sepet.yemek_fiyat}"
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${sepet.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(300, 300)
            .into(t.imageViewYemekResmiSepet)

        t.imageButtonYemekSilSepet.setOnClickListener {
            viewModel.sepettenYemekSil(sepet.sepet_yemek_id)
            viewModel.sepettekiYemekleriYukle()

        }
    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }


}
