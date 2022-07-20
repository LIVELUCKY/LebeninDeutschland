package com.livelucky.lebenindeutschland.ui.components.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.livelucky.lebenindeutschland.ui.components.QuestionCard
import com.livelucky.lebenindeutschland.data.views.QuizViewModel

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


        if (initialized) {
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(viewModel.state.component1().questions) {

                        QuestionCard(it)
                    }

                }
                Button(onClick = { navController.navigate("quiz_config") },modifier = Modifier.fillMaxWidth()) {
                    Text("Retry")
                }
            }

        } else {
            Text(text = "loading")
            CircularProgressIndicator()
        }


    }
}

