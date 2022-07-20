package com.livelucky.lebenindeutschland.ui.components.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.livelucky.lebenindeutschland.ui.components.CustomSlider
import com.livelucky.lebenindeutschland.ui.components.EnumCard
import com.livelucky.lebenindeutschland.data.views.QuizConfigViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuizConfigScreen(
    navController: NavController,
    viewModel: QuizConfigViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()
    val chosen = mutableSetOf(1)
    var numberOfQ = 1

    viewModel.initialize()
    var initialized by remember { mutableStateOf(false) }
    initialized = viewModel.initialized.value
    Scaffold(scaffoldState = scaffoldState) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CustomSlider { numberOfQ = it }
            Button(
                onClick = { navController.navigate("quiz/${chosen.joinToString(":") + ""}/${numberOfQ}") },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text("Start Quiz")
            }

            Text(
                "Quizzes categories ", modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp), fontSize = 30.sp
            )
            if (initialized) {
                LazyVerticalGrid(cells = GridCells.Fixed(2)) {

                    items(viewModel.state.value.categoryAttempts) { c ->

                        EnumCard(c) {
                            val ordinal = c.category.ordinal
                            if (it) {
                                chosen.add(ordinal)
                            } else {
                                chosen.remove(ordinal)
                            }
                        }

                    }


                }
            } else {
                CircularProgressIndicator()
            }

        }
    }
}










