package com.example.tugasprak4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp

@Composable
fun FormulirPendaftaran(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var isSubmitted by remember { mutableStateOf("") }

    val genderList = listOf("Laki-laki", "Perempuan")
    val statusList = listOf("Janda", "Lajang", "Duda")

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3E5F5)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF7B1FA2))
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }
        ElevatedCard(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.9f),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column (
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                verticalArrangement = Arrangement.Top
            ) {
                Text("Nama Lengkap", style = MaterialTheme.typography.labelLarge)
                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    label = { Text("Isian nama lengkap") }
                )
                Text("Jenis Kelamin", style = MaterialTheme.typography.labelLarge)
                genderList.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .selectable(
                                selected = jenisKelamin == item,
                                onClick = { jenisKelamin = item}
                            )
                            .padding(vertical = 2.dp)
                    ) {
                        RadioButton(selected = jenisKelamin == item, onClick = { jenisKelamin = item })
                        Text(item)
                    }
                }
                Text("Status Perkawinan", style = MaterialTheme.typography.labelLarge)
                statusList.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .selectable(
                                selected = status == item,
                                onClick = { status = item }
                            )
                            .padding(vertical = 2.dp)
                    ) {
                        RadioButton(selected = status == item, onClick = { status = item})
                        Text(item)
                    }
                }
                Text("Alamat", style = MaterialTheme.typography.labelLarge)
                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    label = { Text("Alamat") }
                )
                Button(
                    onClick = { isSubmitted = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    enabled = nama.isNotEmpty() && alamat.isNotEmpty()
                ) {
                    Text("Submit")
                }
            }
        }

    }

}