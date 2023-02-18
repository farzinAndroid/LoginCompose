package com.farzin.logincompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun SetUpNavGraph(navController:NavHostController){

    NavHost(
        navController = navController,
        startDestination = Screens.Register.route){

        composable(route = Screens.Register.route){
            RegisterPage(navController)
        }

        composable(route = Screens.Login.route){
            LoginPage(navController)
        }
    }
}