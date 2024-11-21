package com.example.arsitekturmvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.arsitekturmvvm.model.DataMahasiswa


@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    onBackButton: () -> Unit
){
    val listDataMahasiswa = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat),
        Pair("Email", uiStateMahasiswa.email),
        Pair("no HP", uiStateMahasiswa.noHp),
        Pair("NIM", uiStateMahasiswa.NIM)
    )

    Column() {
        listDataMahasiswa.forEach{ items ->
            CardSection(
                judulParam = items.first,
                isiParam = items.second
            )
        }
    }
}
@Composable
fun CardSection(judulParam:String, isiParam:String){
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$isiParam", modifier = Modifier.weight(2f))
        }
    }
}