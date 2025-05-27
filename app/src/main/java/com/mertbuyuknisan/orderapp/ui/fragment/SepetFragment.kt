package com.mertbuyuknisan.orderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mertbuyuknisan.orderapp.R
import com.mertbuyuknisan.orderapp.databinding.FragmentSepetBinding
import com.mertbuyuknisan.orderapp.ui.adapter.SepetAdapter
import com.mertbuyuknisan.orderapp.ui.viewmodel.SepetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {

private lateinit var binding: FragmentSepetBinding
private lateinit var viewModel: SepetViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding= FragmentSepetBinding.inflate(inflater,container,false)



        viewModel.sepetListesi.observe(viewLifecycleOwner) {
            val sepetlerAdapter= SepetAdapter(requireContext(),it,viewModel)
            binding.sepetRecyclerView.adapter=sepetlerAdapter
        }

        binding.sepetRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        viewModel.sepettekiYemekleriYukle()

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SepetViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onResume() {
        super.onResume()

    }


}