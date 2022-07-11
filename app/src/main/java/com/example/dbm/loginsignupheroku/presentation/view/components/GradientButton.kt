package com.example.dbm.loginsignupheroku.presentation.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dbm.loginsignupheroku.R

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    gradient : Brush = Brush.horizontalGradient(listOf(Color(0xFFFFD456), Color(0xFFFF9700))),
    elevation: ButtonElevation,
    shape: Shape,
    onClick: () -> Unit = { }
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        elevation = elevation,
        shape = shape,
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "LOGIN",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_login_button_arrow),
                    contentDescription = "Arrow Login Button",
                    tint = Color.White,
                    modifier = Modifier
                        .requiredHeight(28.dp)
                        .requiredWidth(34.dp)
                )
            }
        }
    }
}