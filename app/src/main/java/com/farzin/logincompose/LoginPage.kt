package com.farzin.logincompose


import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.farzin.logincompose.ui.theme.primaryColor
import com.farzin.logincompose.ui.theme.whiteBackGroundColor

@Composable
fun LoginPage(
    navController: NavHostController,
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    var focusRequester: FocusRequester = remember {
        FocusRequester()
    }

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.TopCenter) {
            Image(painter = painterResource(id = R.drawable.login_image),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp)
            )
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.60f)
            .verticalScroll(rememberScrollState())
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(whiteBackGroundColor)
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "Login",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                OutlinedTextField(value = email, onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)


                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
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
                    label = { Text(text = "password") },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(50.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(0.5f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Login", fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Create An Account", modifier = Modifier
                    .clickable(onClick = {
                        navController.navigate(route = Screens.Register.route) {
                            popUpTo(Screens.Register.route) {
                                inclusive = true
                            }
                        }
                    }),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(20.dp))

            }


        }

    }
}