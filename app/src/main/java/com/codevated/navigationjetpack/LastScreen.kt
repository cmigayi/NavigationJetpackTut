package com.codevated.navigationjetpack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LastScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Last Screen",
            fontSize = 20.sp
        )

//        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.popBackStack()
            navController.popBackStack()
        }) {
            Text(
                text = "Go Back"
            )
        }
    }
}