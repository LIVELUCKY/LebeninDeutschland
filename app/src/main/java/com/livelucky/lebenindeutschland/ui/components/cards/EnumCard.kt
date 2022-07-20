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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EnumCard(categoryAttempts: CategoryAttempts, onClickChoose: (clicked: Boolean) -> Unit) {
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

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val category = categoryAttempts.category

            AssetImageLoad(category.name)



            ValuesAtText(category.txt)
            Row {
                ValuesAtText(  "Attempts Total :" )
                ValuesAtText(categoryAttempts.attemptsTotal.toString())
            }
            Row {
                ValuesAtText("Right Attempts :"  )
                ValuesAtText(categoryAttempts.attemptsRight.toString())
            }
            Row {
                ValuesAtText( "Questions :")
                ValuesAtText(categoryAttempts.questions.toString())
            }



        }
    }
}

@Composable
private fun ValuesAtText(string: String) {
    Text(
        text = string,
        style = TextStyle(color = MaterialTheme.colors.onBackground, fontSize = 12.sp),
        modifier = Modifier
            .padding(10.dp, 0.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.colors.background)
    )
}


