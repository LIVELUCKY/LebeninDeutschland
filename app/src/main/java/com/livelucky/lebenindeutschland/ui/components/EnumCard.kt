package com.livelucky.lebenindeutschland.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.livelucky.lebenindeutschland.domain.model.Category


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EnumCard(c: Category, onClickChoose: (clicked: Boolean) -> Unit) {
    var clicked by remember { mutableStateOf(false) }

    val width: Dp = if (clicked) {
        6.dp
    } else {
        0.dp
    }


    Card(

        shape = RoundedCornerShape(12.dp),
        elevation = 5.dp,

        border = BorderStroke(width, Color.Yellow),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp), onClick = {
            clicked = !clicked
            onClickChoose(clicked)
        }
    ) {

        Box(
            modifier = Modifier
                .height(200.dp)
                .background(color = MaterialTheme.colors.background)
        ) {
            AssetImageLoad(c.name)

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .background(color = MaterialTheme.colors.onBackground)
            ) {
                Text(
                    text = c.txt,
                    style = TextStyle(color = Color.White, fontSize = 12.sp)
                )

            }
        }


    }
}


