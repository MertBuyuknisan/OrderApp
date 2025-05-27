package com.mertbuyuknisan.orderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mertbuyuknisan.orderapp.R
import com.mertbuyuknisan.orderapp.databinding.FragmentDetayBinding
import com.mertbuyuknisan.orderapp.ui.viewmodel.DetayViewModel
import com.mertbuyuknisan.orderapp.ui.viewmodel.SepetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
private lateinit var binding: FragmentDetayBinding
private lateinit var viewModel: DetayViewModel
var adetSayisiInt=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle: DetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek

        binding.textViewYemekAdi.text = gelenYemek.yemek_adi
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${gelenYemek.yemek_resim_adi}"
        Glide.with(requireContext()).load(url).override(500, 500)
            .into(binding.imageViewDetayYemekResim)
        binding.textViewYemekFiyatGoster.text = "${gelenYemek.yemek_fiyat} ₺ (Adet)"
        binding.buttonArti.setOnClickListener {

            var adetSayisiStr=binding.textViewAdetSayisi.text.toString()
            adetSayisiInt=adetSayisiStr.toInt()
            adetSayisiInt++
            binding.textViewAdetSayisi.text=adetSayisiInt.toString()
            binding.textViewToplamTutar.text="Tutar: ${(gelenYemek.yemek_fiyat*adetSayisiInt)} ₺"
        }
        binding.buttonEksi.setOnClickListener {
            var adetSayisiStr=binding.textViewAdetSayisi.text.toString()
            var adetSayisiInt=adetSayisiStr.toInt()
            if(adetSayisiInt>0){
                adetSayisiInt--
                binding.textViewAdetSayisi.text =adetSayisiInt.toString()
                binding.textViewToplamTutar.text="Tutar: ${(gelenYemek.yemek_fiyat*adetSayisiInt)} ₺"
            }
            else{
                Toast.makeText(requireContext(),"Ürün adedi en az 0 olabilir.", Toast.LENGTH_SHORT).show()
            }
        }
binding.addToCart.setOnClickListener {
    viewModel.sepeteYemekEkle(gelenYemek.yemek_adi,gelenYemek.yemek_resim_adi,gelenYemek.yemek_fiyat,adetSayisiInt)
    binding.lottieAnimation.playAnimation()

}
        binding.lottieAnimation.pauseAnimation()

        return binding.root

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }


    }





