package com.livelucky.lebenindeutschland.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.model.util.QuestionWithOptins
import kotlinx.coroutines.launch

@Composable
fun OptionsList(
    questionWithOptins: QuestionWithOptins,
    viewModel: QuizViewModel = hiltViewModel()
) {
    var chosed by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        questionWithOptins.options.forEach { it ->
            OptionCard(it, chosed) {
                chosed = true
                coroutineScope.launch {
                    viewModel.insertAttempt(
                        questionWithOptins.embeddedQuestion,
                        Attempt(it.is_Correct)
                    )
                }
            }


        }

    }


}