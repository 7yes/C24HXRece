package com.jes.c24hxrece.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jes.c24hxrece.data.model.SampleResponseItem
import com.jes.c24hxrece.domain.GetAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewMoSample @Inject constructor(private val getAllUseCase: GetAllUseCase):ViewModel() {

    private val _lista = MutableLiveData<List<SampleResponseItem>>()
    val lista: LiveData<List<SampleResponseItem>> = _lista

    fun getAllData(){
        viewModelScope.launch {
            val a = getAllUseCase()
            _lista.value = a
            Log.d("TAJ", "getAllData: bb ${_lista.value} ")
        }
    }

}


