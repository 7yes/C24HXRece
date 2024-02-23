package com.jes.c24hxrece.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jes.c24hxrece.data.model.SampleResponseItem
import com.jes.c24hxrece.databinding.FragmentHomeBinding
import com.jes.c24hxrece.ui.ViewMoSample
import com.jes.c24hxrece.ui.adapter.AdapterSample
import com.jes.c24hxrece.ui.uistatemodel.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewmodel: ViewMoSample by viewModels()
    private lateinit var adapter: AdapterSample
    private var lista = mutableListOf<SampleResponseItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        viewmodel.getAllData()
        initRV()
//        viewmodel.lista.observe(viewLifecycleOwner){
//            lista.clear()
//            lista.addAll(it)
//            adapter.notifyDataSetChanged()
//        }
        binding.btnReload.setOnClickListener { viewmodel.update() }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.uiState.collect {
                    when (it) {
                        is UiState.Error -> {
                            binding.progress.isVisible = false
                            binding.btnReload.isVisible = true
                            binding.ivError.isVisible = true
                            Toast.makeText(requireContext(), "Error: ${it.msg}", Toast.LENGTH_SHORT)
                                .show()
                        }

                        UiState.Loading -> {
                            binding.progress.isVisible = true
                            binding.btnReload.isVisible = false
                            binding.ivError.isVisible = false
                        }
                        is UiState.Sucess<*> -> {
                            binding.progress.isVisible = false
                            lista.clear()
                            lista.addAll(it.data as List<SampleResponseItem>)
                            adapter.notifyDataSetChanged()
                        }
                    }
                }
            }
        }
        return binding.root
    }

    private fun initRV() {
        adapter = AdapterSample(lista)
//        {
//            viewmodel.updateDetail(it)
//            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
//        }
        binding.rvList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvList.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

