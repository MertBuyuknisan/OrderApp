package com.mertbuyuknisan.orderapp.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getYemeklerDao():YemeklerDao{
            return RetrofitClient.getClient(BASE_URL).create(YemeklerDao::class.java)
        }
        fun getSepetlerDao(): SepetlerDao{
            return RetrofitClient.getClient(BASE_URL).create(SepetlerDao::class.java)
        }
    }
}