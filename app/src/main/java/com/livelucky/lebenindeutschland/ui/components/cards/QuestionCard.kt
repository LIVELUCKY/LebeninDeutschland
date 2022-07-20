package com.livelucky.lebenindeutschland.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.livelucky.lebenindeutschland.domain.model.util.QuestionWithOptins

@Composable
fun QuestionCard(q: QuestionWithOptins) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 10.dp
    ) {
        Column {
            if (q.embeddedQuestion.hasImage) AssetImageLoad(q.embeddedQuestion.imageId.toString())
            Text(text = q.embeddedQuestion.question, modifier = Modifier.padding(3.dp))
            OptionsList(q)
        }


    }
}