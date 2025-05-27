package com.mertbuyuknisan.orderapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mertbuyuknisan.orderapp.data.entity.Sepetler
import com.mertbuyuknisan.orderapp.data.repo.SepetlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class SepetViewModel @Inject constructor(var sepetlerRepository: SepetlerRepository): ViewModel(){
    var sepetListesi= MutableLiveData<List<Sepetler>>()
    init {
        sepettekiYemekleriYukle()
    }
    fun sepettekiYemekleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                sepetListesi.value=sepetlerRepository.sepettekiYemekleriYukle()
            }catch (e: Exception){}
        }
    }
    fun sepeteYemekEkle(yemek_adi: String,yemek_resim_adi: String,yemek_fiyat: Int,yemek_siparis_adet:Int,kullanici_adi: String){
        CoroutineScope(Dispatchers.Main).launch {
            sepetlerRepository.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        }
    }

    fun sepettenYemekSil(sepet_yemek_id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            sepetlerRepository.sepettenYemekSil(sepet_yemek_id)
            sepettekiYemekleriYukle()
        }
    }
}