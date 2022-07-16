package com.example.dbm.loginsignupheroku.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dbm.loginsignupheroku.presentation.view.screens.LoginScreen
import com.example.dbm.loginsignupheroku.presentation.view.theme.LoginSignUpHerokuTheme
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
                        viewModel.sendLoginData(username, password)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 36.dp)
                    )
                }
            }
        }
    }
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
                loginButtonPressed = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 36.dp)
            )
        }
    }
}