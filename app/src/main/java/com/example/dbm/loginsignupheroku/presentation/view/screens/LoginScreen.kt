package com.example.dbm.loginsignupheroku.presentation.view.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dbm.loginsignupheroku.R
import com.example.dbm.loginsignupheroku.presentation.view.components.GradientButton

@Composable
fun LoginScreen(
    username: String,
    password: String,
    usernameChange: (String) -> Unit,
    passwordChange: (String) -> Unit,
    loginButtonPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Login",
            fontSize = 34.sp,
            fontWeight = FontWeight.W800,
            modifier = Modifier
                .align(Alignment.Start)
        )
        Text(
            text = "Please sign in to continue",
            fontSize = 20.sp,
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
            textStyle = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth().shadow(10.dp),
            label = {
                Text(text = "EMAIL", fontWeight = FontWeight.Bold)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_login_email),
                    contentDescription = "Login Password",
                    modifier = Modifier
                        .requiredHeight(28.dp)
                        .requiredWidth(34.dp)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background
            )
        )
        Spacer(modifier = Modifier
            .height(8.dp)
        )
        TextField(
            value = password,
            onValueChange = {
                passwordChange(it)
            },
            textStyle = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth().shadow(10.dp),
            label = {
                Text(text = "PASSWORD", fontWeight = FontWeight.Bold) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_login_password),
                    contentDescription = "Login Password",
                    modifier = Modifier
                        .requiredHeight(28.dp)
                        .requiredWidth(34.dp)
                )
            },
            trailingIcon = {
                Text(
                    text = "FORGOT",
                    color = Color(0xFFFF9700),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .clickable {
                            Log.d("Forgot", "Password Recovery was pressed")
                        }
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background
            )
        )
        Spacer(modifier = Modifier
            .height(36.dp)
        )
        GradientButton(
            modifier = Modifier
                .align(Alignment.End),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 6.dp,
                pressedElevation = 8.dp,
                disabledElevation = 0.dp
            ),
            onClick = {
                loginButtonPressed()
            },
            shape = RoundedCornerShape(50)
        )
        Spacer(modifier = Modifier.weight(1f))
        ClickableText(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600)
                ) {
                    append("Don't have an account? ")
                }
                withStyle(style = SpanStyle(
                    color = Color(0xFFFF9700),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold)
                ) {
                    append("Sign up")
                }
            },
            modifier = Modifier.padding(bottom = 24.dp),
            onClick = { offset ->
                if(offset >= 24){
                    Log.d("ClickableText", "The Sign up text was clicked!!")
                }
            }
        )
    }
}