package com.sample.estruturabasica

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Sobre",
                navigationIcon = Icons.Default.Info,
                showBackButton = true,
                navController = navController
            )
        },
        bottomBar = {
            BottomAppBar {
                BottomNavItem(
                    icon = Icons.Default.Info,
                    label = "Sobre",
                    isSelected = true,
                    onClick = { /* ja esta na sobre*/ }
                )
                BottomNavItem(
                    icon = Icons.Default.Home,
                    label = "Home",
                    isSelected = false,
                    onClick = { navController.navigate(Screen.Home.route) }
                )
                BottomNavItem(
                    icon = Icons.Default.Email,
                    label = "Contato",
                    isSelected = false,
                    onClick = { navController.navigate(Screen.Contact.route) }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* a fazer */ },
            ) {
                Icon(Icons.Filled.Add, "Maiszinho")
            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = iliadText,
                color = Color.White,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

val iliadText = """
    Canta, ó deusa, a cólera de Aquiles, o Pelida 
    (mortífera!, que tantas dores trouxe aos Aqueus 
    e tantas almas valentes de heróis lançou ao Hades, 
    ficando seus corpos como presa para cães 
    e aves carniceiras, enquanto se cumpria a vontade de Zeus), 
    desde o momento em que primeiro se desentenderam 
    o Atrida, soberano dos homens, e o divino Aquiles.
    
    Qual dos deuses os pôs a lutar com tanta hostilidade? 
    O filho de Leto e de Zeus. Irritado com o rei, 
    suscitou uma peste maligna no exército, e o povo perecia, 
    porque o Atrida havia insultado Crises, seu sacerdote. 
    Este fora até as naus dos Aqueus, de rápidos navios, 
    para libertar sua filha, trazendo consigo um resgate infinito. 
    Tinha nas mãos as insígnias de Apolo, o longífero, 
    penduradas numa vara de ouro, e suplicava a todos os Aqueus, 
    sobretudo aos dois Atridas, comandantes de povos.
    
    "Ó Atridas e outros Aqueus de belas cnêmides, 
    possam os deuses que habitam o Olimpo conceder-vos 
    saquear a cidade de Príamo e voltar são e salvo para casa; 
    mas libertai-me a minha filha e aceitai o resgate, 
    por respeito a Zeus Crónida, o longífero Apolo."
""".trimIndent()

@Preview (showBackground = true)
@Composable
fun PreviewAboutScreen(){
    AboutScreen(
        navController = rememberNavController()
    )
}