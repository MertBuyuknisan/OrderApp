package com.mertbuyuknisan.orderapp.data.repo

import com.mertbuyuknisan.orderapp.data.datasource.YemeklerDataSource
import com.mertbuyuknisan.orderapp.data.entity.Yemekler


class YemeklerRepository  (var yemeklerDataSource: YemeklerDataSource) {
    suspend fun yemekleriYukle() : List<Yemekler> = yemeklerDataSource.yemekleriYukle()
}