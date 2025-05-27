package com.mertbuyuknisan.orderapp.data.repo

import com.mertbuyuknisan.orderapp.data.datasource.SepetlerDataSource
import com.mertbuyuknisan.orderapp.data.entity.Sepetler

class SepetlerRepository(var sepetlerDataSource: SepetlerDataSource) {
    suspend fun sepeteYemekEkle(yemek_adi: String,yemek_resim_adi: String,yemek_fiyat:Int,yemek_siparis_adet: Int,kullanici_adi: String) = sepetlerDataSource.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

    suspend fun sepettekiYemekleriYukle() : List<Sepetler> = sepetlerDataSource.sepettekiYemekleriYukle("helloworld")

    suspend fun sepettenYemekSil(sepet_yemek_id: Int) = sepetlerDataSource.sepettenYemekSil(sepet_yemek_id,"helloworld")
}