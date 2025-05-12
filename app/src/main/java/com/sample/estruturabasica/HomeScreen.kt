package com.sample.estruturabasica

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sample.estruturabasica.R

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Home",
                navigationIcon = Icons.Default.Home,
                showBackButton = false
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 30.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black)
                    .height(70.dp),
                containerColor = Color.LightGray
            ) {
                BottomNavItem(
                    icon = Icons.Default.Home,
                    label = "Home",
                    isSelected = true,
                    onClick = { /* Já estamos na home */ }
                )
                BottomNavItem(
                    icon = Icons.Default.Info,
                    label = "Sobre",
                    isSelected = false,
                    onClick = { navController.navigate(Screen.About.route) }
                )
                BottomNavItem(
                    icon = Icons.Default.Email,
                    label = "Contato",
                    isSelected = false,
                    onClick = { navController.navigate(Screen.Contact.route) }
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Text("Bem-vindo ao App!")
        }
    }
}


@Preview (showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        navController = rememberNavController()
    )
}