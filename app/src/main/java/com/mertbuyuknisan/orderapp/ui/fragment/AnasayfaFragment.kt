package com.mertbuyuknisan.orderapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mertbuyuknisan.orderapp.databinding.FragmentAnasayfaBinding
import com.mertbuyuknisan.orderapp.ui.adapter.YemeklerAdapter
import com.mertbuyuknisan.orderapp.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAnasayfaBinding.inflate(inflater,container,false)

        viewModel.yemeklerListesi.observe(viewLifecycleOwner) {
            val yemeklerAdapter= YemeklerAdapter(requireContext(),it,viewModel)
            binding.anasayfaRecycler.adapter=yemeklerAdapter
        }

        binding.anasayfaRecycler.layoutManager= StaggeredGridLayoutManager(2,
            StaggeredGridLayoutManager.VERTICAL)

        return binding.root



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
    }

}