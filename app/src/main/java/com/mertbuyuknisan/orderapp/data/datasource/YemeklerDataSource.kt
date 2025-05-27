package com.mertbuyuknisan.orderapp.data.datasource

import com.mertbuyuknisan.orderapp.data.entity.Yemekler
import com.mertbuyuknisan.orderapp.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource(var yemeklerDao: YemeklerDao) {
    suspend fun yemekleriYukle(): List<Yemekler> = withContext (Dispatchers.IO){
        return@withContext yemeklerDao.yemekleriYukle().yemekler
    }
}