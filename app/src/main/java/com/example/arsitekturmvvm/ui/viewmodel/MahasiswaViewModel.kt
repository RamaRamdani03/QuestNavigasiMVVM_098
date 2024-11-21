package com.example.arsitekturmvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.arsitekturmvvm.model.DataMahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DataMahasiswa())
    val uiState: StateFlow<DataMahasiswa> = _uiState.asStateFlow()

    fun saveDataM(listDatamahasiswa: List<String>){
        _uiState.update { dataMhs ->
            dataMhs.copy(
                nama = listDatamahasiswa[0],
                gender = listDatamahasiswa[1],
                alamat = listDatamahasiswa[2],
                email = listDatamahasiswa[3],
                noHp = listDatamahasiswa[4],
                NIM = listDatamahasiswa[5],
            )
        }
    }
}