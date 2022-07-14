package com.livelucky.lebenindeutschland.ui.components.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.ui.components.CustomSlider
import com.livelucky.lebenindeutschland.ui.components.EnumCard


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuizConfigScreen(
    navController: NavController
) {

    val scaffoldState = rememberScaffoldState()
    val chosen = mutableSetOf(1)
    var numberofQ = 1

    Scaffold(scaffoldState = scaffoldState) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp)
        ) {

            CustomSlider { numberofQ = it }
            Button(
                onClick = { navController.navigate("quiz/${chosen.joinToString(":") + ""}/${numberofQ}") },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text("Start Quiz")
            }
            LazyVerticalGrid(cells = GridCells.Fixed(2)) {

                items(Category.values()) { c ->
                    EnumCard(c) {
                        if (it) {
                            chosen.add(c.ordinal)
                        } else {
                            chosen.remove(c.ordinal)
                        }
                    }

                }


            }

        }
    }
}










