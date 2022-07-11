package com.example.dbm.loginsignupheroku.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dbm.loginsignupheroku.R
import com.example.dbm.loginsignupheroku.presentation.ui.theme.LoginSignUpHerokuTheme
import com.example.dbm.loginsignupheroku.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginSignUpHerokuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var username by remember { mutableStateOf("")}
                    var password by remember { mutableStateOf("")}

                    val viewModel: LoginViewModel = viewModel()

                    LoginScreen(username, password, {
                        username = it
                    }, {
                        password = it
                    }, {
                        //Call ViewModel with data
                        viewModel.sendLoginData(username, password)
                        //println("Login button was pressed")
                    })
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    username: String,
    password: String,
    usernameChange: (String) -> Unit,
    passwordChange: (String) -> Unit,
    loginButtonPressed: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Login",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
        )
        Text(
            text = "Please sign in to continue",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier
            .height(52.dp)
        )
        TextField(
            value = username,
            onValueChange = {
                usernameChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("EMAIL")
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp)
        )
        TextField(
            value = password,
            onValueChange = {
                passwordChange(it)
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text("PASSWORD")
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                Text(
                    text = "FORGOT",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .clickable {
                            //TODO: Password recovery
                        }
                )
            }
        )
        Spacer(modifier = Modifier
            .height(36.dp)
        )
        Button(
            modifier = Modifier
                .align(Alignment.End),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 6.dp,
                pressedElevation = 8.dp,
                disabledElevation = 0.dp
            ),
            onClick = {
                loginButtonPressed()
            },
            shape = RoundedCornerShape(50)
        ) {
            Text(
                text = "LOGIN",
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_login_button_arrow),
                contentDescription = "Arrow Login Button",
                modifier = Modifier
                    .requiredHeight(28.dp)
                    .requiredWidth(34.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Don't have an account? Sign in",
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.fillMaxSize())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginSignUpHerokuTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LoginScreen(
                username = "Daniel",
                password = "123456789ABCDEF",
                usernameChange = {},
                passwordChange = {},
                loginButtonPressed = {})
        }
    }
}