package com.mertbuyuknisan.orderapp.retrofit

import com.mertbuyuknisan.orderapp.data.entity.YemeklerCevap
import retrofit2.http.GET

interface YemeklerDao {
    @GET("/yemekler/tumYemekleriGetir.php")
    suspend fun yemekleriYukle(): YemeklerCevap
}