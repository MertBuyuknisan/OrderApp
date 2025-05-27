package com.mertbuyuknisan.orderapp.retrofit

import com.mertbuyuknisan.orderapp.data.entity.CRUDCevap
import com.mertbuyuknisan.orderapp.data.entity.SepetlerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

//http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php
interface SepetlerDao {

    @POST("/yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun sepettekiYemekleriYukle(@Field("kullanici_adi") kullanici_adi: String): SepetlerCevap

    @POST("/yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun sepeteYemekEkle(@Field("yemek_adi") yemek_adi: String,
                           @Field("yemek_resim_adi") yemek_resim_adi:String,
                           @Field("yemek_fiyat") yemek_fiyat: Int,
                           @Field("yemek_siparis_adet") yemek_siparis_adet: Int,
                           @Field("kullanici_adi") kullanici_adi: String): CRUDCevap

    @POST("/yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun sepettenYemekSil(@Field("sepet_yemek_id") sepet_yemek_id: Int,@Field("kullanici_adi") kullanici_adi: String): CRUDCevap

}