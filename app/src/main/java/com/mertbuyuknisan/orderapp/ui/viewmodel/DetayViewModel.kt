package com.mertbuyuknisan.orderapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mertbuyuknisan.orderapp.data.repo.SepetlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel @Inject constructor(var sepetlerRepository: SepetlerRepository): ViewModel() {
    fun sepeteYemekEkle(yemek_adi: String,yemek_resim_adi: String,yemek_fiyat:Int,yemek_siparis_adet: Int){
        CoroutineScope(Dispatchers.Main).launch {
        sepetlerRepository.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,"helloworld")
        }
    }
}