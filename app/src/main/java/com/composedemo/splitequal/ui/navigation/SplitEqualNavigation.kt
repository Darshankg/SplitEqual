package com.composedemo.splitequal.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.composedemo.splitequal.ui.screens.HomeScreen
import com.composedemo.splitequal.ui.screens.SplashScreen
import com.composedemo.splitequal.ui.screens.ThankYouScreen


@Composable
fun SplitEqualNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.SplashScreen.name){
        composable(Destinations.SplashScreen.name){
            SplashScreen(navController = navController)
        }

        composable(Destinations.HomeScreen.name){
            HomeScreen(navController = navController)
        }

        composable(Destinations.ThankYouScreen.name){
            ThankYouScreen()
        }
    }
}