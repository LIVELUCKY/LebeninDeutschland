package com.livelucky.lebenindeutschland.ui.components.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.ui.components.QuestionsList
import com.livelucky.lebenindeutschland.ui.components.QuizViewModel

@Composable
fun QuizScreen(
    navController: NavHostController,
    categories: List<Category>,
    numberOfQuestions: Int = 0,
    viewModel: QuizViewModel = hiltViewModel()
) {

    viewModel.initialize(categories, numberOfQuestions)
    var initialized by remember { mutableStateOf(false) }
    initialized = viewModel.initialized
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            if (initialized) {


                QuestionsList(viewModel.state.component1())
            } else {
                Text(text = "loading")
                CircularProgressIndicator()
            }


            Button(onClick = { navController.navigate("quiz_config") }) {
                Text("Retry")
            }
        }
    }
}

