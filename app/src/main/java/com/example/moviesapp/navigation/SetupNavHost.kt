package com.example.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesapp.MainViewModel
import com.example.moviesapp.screens.DetailScreen
import com.example.moviesapp.screens.MainScreen
import com.example.moviesapp.screens.SplashScreen
import com.example.moviesapp.utils.Constants

sealed class Screens(val route: String) {
    object Splash: Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main: Screens(route = Constants.Screens.MAIN_SCREEN)
    object Detail: Screens(route = Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetUpNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Detail.route + "/{Id}") { backStackEntry ->
            DetailScreen(
                viewModel = viewModel,
                itemId = backStackEntry.arguments?.getString("Id") ?: "1"
            )

        }
    }
}