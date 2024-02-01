package com.jes.c24hxrece.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jes.c24hxrece.domain.GetAllUseCase
import com.jes.c24hxrece.ui.uistatemodel.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // en comentarios dejo esto trabajando con livedata
class ViewMoSample @Inject constructor(private val getAllUseCase: GetAllUseCase) : ViewModel() {

    //private val _lista = MutableLiveData<List<SampleResponseItem>>()
    //val lista: LiveData<List<SampleResponseItem>> = _lista

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    //    fun getAllData(){ // esta fun es livedata normal
//        viewModelScope.launch {
//            val a = getAllUseCase()
//            _lista.value = a
//            Log.d("TAJ", "getAllData: bb ${_lista.value} ")
//        }
//    }
    fun getAllData() { // esta fun es con UIStates
        viewModelScope.launch {
            try {
                val a = getAllUseCase()
                if (a.isNullOrEmpty()) _uiState.value = UiState.Error("Server Error")
                else _uiState.value = UiState.Sucess(a)
                Log.d("TAJ", "getAllData: bb $a ")
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.toString())
            }

        }
    }

    fun update() {
        _uiState.value = UiState.Loading
        getAllData()
    }
}


