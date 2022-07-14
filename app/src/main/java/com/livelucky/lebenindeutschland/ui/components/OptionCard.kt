package com.livelucky.lebenindeutschland.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.livelucky.lebenindeutschland.domain.model.Option

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OptionCard(option: Option, clicked: Boolean, onClickChoose: () -> Unit) {
    val width: Dp = if (clicked) {
        4.dp
    } else {
        0.dp
    }

    val color: Color = if (option.is_Correct and clicked) {
        Color.Green
    } else if (clicked) {
        Color.Red
    } else {
        Color.White
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 5.dp,
        border = BorderStroke(width, color), onClick = {
            onClickChoose()
        }
    ) {

        Text(text = option.text, modifier = Modifier.padding(6.dp))
    }
}