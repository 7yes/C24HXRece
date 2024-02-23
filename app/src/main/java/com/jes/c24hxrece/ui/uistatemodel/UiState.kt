package com.jes.c24hxrece.ui.uistatemodel

sealed class UiState {
    data object Loading: UiState()
    data class Sucess<T>(val data:T):UiState()
    data class Error(val msg:String):UiState()

}