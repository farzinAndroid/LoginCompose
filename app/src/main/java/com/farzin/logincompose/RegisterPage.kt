package com.farzin.logincompose

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.farzin.logincompose.ui.theme.primaryColor
import com.farzin.logincompose.ui.theme.whiteBackGroundColor
import kotlin.system.exitProcess

@Composable
fun RegisterPage(
    navController:NavHostController
) {

    var nameValue by remember {
        mutableStateOf("")
    }

    var emailValue by remember {
        mutableStateOf("")
    }

    var phoneValue by remember {
        mutableStateOf("")
    }

    var passwordValue by remember {
        mutableStateOf("")
    }

    var confirmPasswordValue by remember {
        mutableStateOf("")
    }

    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    var confirmpasswordVisibility by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.TopCenter) {
            Image(painter = painterResource(id = R.drawable.register_page),
                contentDescription = null)
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.70f)
            .verticalScroll(rememberScrollState())
            .background(whiteBackGroundColor)
            .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Register",
                color = Color.Black,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Column(modifier = Modifier
                .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = nameValue,
                    onValueChange = { nameValue = it },
                    label = { Text(text = "Name") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )

                OutlinedTextField(
                    value = emailValue,
                    onValueChange = { emailValue = it },
                    label = { Text(text = "Email") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )

                OutlinedTextField(
                    value = phoneValue,
                    onValueChange = { phoneValue = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    label = { Text(text = "Phone Number") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )

                OutlinedTextField(
                    value = passwordValue,
                    onValueChange = { passwordValue = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye),
                                contentDescription = null,
                                tint = if (passwordVisibility) primaryColor else Color.Gray
                            )
                        }
                    },
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    label = { Text(text = "Password") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )

                OutlinedTextField(
                    value = confirmPasswordValue,
                    onValueChange = { confirmPasswordValue = it },
                    label = { Text(text = "Confirm Password") },
                    trailingIcon = {
                        IconButton(onClick = {
                            confirmpasswordVisibility = !confirmpasswordVisibility
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye),
                                contentDescription = null,
                                tint = if (confirmpasswordVisibility) primaryColor else Color.Gray
                            )
                        }
                    },
                    visualTransformation = if (confirmpasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(50.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(0.5f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Sign In", fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Login Instead", modifier = Modifier
                    .clickable(onClick = {
                        navController.navigate(route = Screens.Login.route)
                    }),
                    color = Color.Black
                )
            }
        }
    }
}