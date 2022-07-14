package com.livelucky.lebenindeutschland.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.livelucky.lebenindeutschland.domain.model.util.Quiz

@Composable
fun QuestionsList(quiz: Quiz) {

    val questions = quiz.questions


    LazyColumn() {
        items(questions) { q ->

            QuestionCard(q)
        }

    }

}