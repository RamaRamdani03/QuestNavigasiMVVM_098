package com.example.arsitekturmvvm.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listjk: List<String>,
    onSubmitClicked: (MutableList<String>) -> Unit
){

    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    var NIM by remember { mutableStateOf("")}

    val dataMahasiswa: MutableList<String> = mutableListOf(nama, selectedGender, alamat, email, noHp, NIM)

    Column (
        Modifier
            .fillMaxSize()
            .padding(16.dp)
        , horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukan nama")}
            ,label = {Text("Nama")}
            ,modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp))

        Row (){
            listjk.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = selectedGender == item,
                        onClick = {
                            selectedGender = item
                    })
                    Text(item) }
            }
        }


        OutlinedTextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukan email")}
            ,label = {Text("email")}
            ,modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp))

        OutlinedTextField(value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukan alamat")}
            ,label = {Text("alamat")}
            ,modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp))

        OutlinedTextField(value = noHp,
            onValueChange = {noHp = it},
            placeholder = { Text("Masukan noHp")}
            ,label = {Text("noHp")}
            , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            ,modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp))

        OutlinedTextField(value = NIM,
            onValueChange = {NIM = it},
            placeholder = { Text("Masukan NIM")}
            ,label = {Text("NIM")}
            , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            ,modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp))

        Button(onClick = { onSubmitClicked(dataMahasiswa)})
        {
            Text("Simpan")
        }
    }
}