package com.mertbuyuknisan.orderapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mertbuyuknisan.orderapp.data.entity.Yemekler
import com.mertbuyuknisan.orderapp.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var yemeklerRepository:YemeklerRepository): ViewModel(){
    var yemeklerListesi= MutableLiveData<List<Yemekler>>()
    init {
        yemekleriYukle()
    }

    fun yemekleriYukle(){
        CoroutineScope(Dispatchers.Main).launch{
            try {
                yemeklerListesi.value=yemeklerRepository.yemekleriYukle()

            }catch (e: Exception){}
        }
    }
}