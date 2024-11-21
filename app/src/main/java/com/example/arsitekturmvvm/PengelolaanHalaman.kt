package com.example.arsitekturmvvm

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.arsitekturmvvm.ui.viewmodel.MahasiswaViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.arsitekturmvvm.model.DataJenisKelamin
import com.example.arsitekturmvvm.ui.view.DetailMahasiswaView
import com.example.arsitekturmvvm.ui.view.FormMahasiswaView

enum class Halaman{
    Formulir,
    Detail,
}

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel()
) {
    Scaffold {isipadding ->
        val stateUI by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navController, startDestination = Halaman.Formulir.name
        ) {
            composable(route = Halaman.Formulir.name){
                val konteks = LocalContext.current
                FormMahasiswaView(

                    //Di bawah ini merupakan dari parameter halaman FormulirView
                    listjk = DataJenisKelamin.listjk.map { //Data JenisKelamin dapat dari object
                        id -> konteks.resources.getString(id)
                    },
                    onSubmitClicked = {
                        viewModel.saveDataM(it)
                        navController.navigate(Halaman.Detail.name)
                    }
                )
            }
        }
    }
}