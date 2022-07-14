package com.livelucky.lebenindeutschland.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.ui.components.screens.QuizConfigScreen
import com.livelucky.lebenindeutschland.ui.components.screens.QuizScreen
import com.livelucky.lebenindeutschland.ui.theme.LebenInDeutschlandTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LebenInDeutschlandTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "quiz_config"
                    ) {
                        composable("quiz_config") {
                            QuizConfigScreen(navController = navController)
                        }
                        composable(
                            route = "quiz/{categories}/{numberQ}",
                            arguments = listOf(
                                navArgument("categories") {
                                    type = NavType.StringType
                                },
                                navArgument("numberQ") {
                                    type = NavType.IntType
                                },
                            )
                        ) {
                            val categories = it.arguments?.getString("categories")
                            val numberQ = it.arguments?.getInt("numberQ")

                            if (numberQ != null && categories != null) {
                                QuizScreen(
                                    navController = navController,
                                    categories = categories.split(":")
                                        .map { s -> Category.values()[s.toInt()] },
                                    numberOfQuestions = numberQ
                                )

                            }

                        }

                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    LebenInDeutschlandTheme {
//        Greeting("Android")
//    }
//}
