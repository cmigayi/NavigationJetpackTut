package com.codevated.navigationjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codevated.navigationjetpack.ui.theme.NavigationJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationJetpackTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(Screen.Home.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(
                            Screen.Second.route + "/{url}/{counter}",
                            arguments = listOf(
                                navArgument("url") {type = NavType.StringType},
                                navArgument("counter") {type = NavType.IntType}
                            )
                        ) { backStackEntry ->
                            SecondScreen(
                                navController = navController,
                                backStackEntry = backStackEntry
                            )
                        }
                        composable(Screen.Last.route) {
                            LastScreen(navController = navController)
                        }
                    }

                }
            }
        }
    }
}

