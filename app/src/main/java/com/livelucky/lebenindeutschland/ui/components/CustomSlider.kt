package com.livelucky.lebenindeutschland.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun CustomSlider(onValueChangeFinished: (value: Int) -> Unit) {
    var sliderPosition by remember { mutableStateOf(1f) }
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        Text(text = "Number Of Questions in the Quiz : "+sliderPosition.roundToInt().toString())
        Slider(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            value = sliderPosition, onValueChange = { sliderPosition = it },
            valueRange = 1f..50f,
            onValueChangeFinished = { onValueChangeFinished(sliderPosition.roundToInt()) },
            steps = 50
        )
    }




}