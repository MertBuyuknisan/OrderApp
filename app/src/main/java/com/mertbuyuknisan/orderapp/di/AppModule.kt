package com.mertbuyuknisan.orderapp.di

import com.mertbuyuknisan.orderapp.data.datasource.SepetlerDataSource
import com.mertbuyuknisan.orderapp.data.datasource.YemeklerDataSource
import com.mertbuyuknisan.orderapp.data.repo.SepetlerRepository
import com.mertbuyuknisan.orderapp.data.repo.YemeklerRepository
import com.mertbuyuknisan.orderapp.retrofit.ApiUtils
import com.mertbuyuknisan.orderapp.retrofit.SepetlerDao
import com.mertbuyuknisan.orderapp.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerRepository(yemeklerDataSource: YemeklerDataSource): YemeklerRepository{
        return YemeklerRepository(yemeklerDataSource)
    }
    @Provides
    @Singleton
    fun provideYemeklerDataSource(yemeklerDao: YemeklerDao): YemeklerDataSource{
        return YemeklerDataSource(yemeklerDao)
    }
    @Provides
    @Singleton
    fun provideYemeklerDao(): YemeklerDao{
        return ApiUtils.getYemeklerDao()
    }

    @Provides
    @Singleton
    fun provideSepetlerRepository(sepetlerDataSource: SepetlerDataSource): SepetlerRepository{
        return SepetlerRepository(sepetlerDataSource)
    }
    @Provides
    @Singleton
    fun provideSepetlerDataSource(sepetlerDao: SepetlerDao): SepetlerDataSource{
        return SepetlerDataSource(sepetlerDao)
    }

    @Provides
    @Singleton
    fun provideSepetlerDao(): SepetlerDao{
        return ApiUtils.getSepetlerDao()
    }

}