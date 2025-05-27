package com.mertbuyuknisan.orderapp.data.datasource

import com.mertbuyuknisan.orderapp.data.entity.CRUDCevap
import com.mertbuyuknisan.orderapp.data.entity.Sepetler
import com.mertbuyuknisan.orderapp.retrofit.SepetlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SepetlerDataSource(var sepetlerDao: SepetlerDao) {


    suspend fun sepeteYemekEkle(yemek_adi: String,yemek_resim_adi: String,yemek_fiyat:Int,yemek_siparis_adet: Int,kullanici_adi: String){
     sepetlerDao.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet, kullanici_adi)
}
    suspend fun sepettekiYemekleriYukle(kullanici_adi: String) : List<Sepetler> = withContext(Dispatchers.IO) {
        return@withContext sepetlerDao.sepettekiYemekleriYukle(kullanici_adi).sepet_yemekler
    }

    suspend fun sepettenYemekSil(sepet_yemek_id: Int,kullanici_adi: String){
        sepetlerDao.sepettenYemekSil(sepet_yemek_id,kullanici_adi)
    }


}