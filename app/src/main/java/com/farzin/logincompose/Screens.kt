package com.farzin.logincompose

sealed class Screens(val route: String) {

    object Register : Screens(route = "register_screen")
    object Login : Screens(route = "login_screen")
}

