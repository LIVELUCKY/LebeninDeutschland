package com.livelucky.lebenindeutschland.ui.components

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.domain.model.Option
import com.livelucky.lebenindeutschland.domain.model.Question
import com.livelucky.lebenindeutschland.domain.model.util.QuestionWithOptins
import com.livelucky.lebenindeutschland.domain.model.util.Quiz
import com.livelucky.lebenindeutschland.domain.use.Provider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuizViewModel @Inject constructor(
    private val provider: Provider
) : ViewModel() {

    var initialized = false
    private var numberOfQuestions: Int = 0

    val state = mutableStateOf(Quiz())
    fun initialize(categories: List<Category>, numberOfQuestions: Int) {
        if (!initialized) {


            this.numberOfQuestions = numberOfQuestions
            state.component1().categories = categories

            viewModelScope.launch(Dispatchers.IO) {
                val xQuestionByCategorys =
                    provider.getXQuestionByCategorys(numberOfQuestions, categories)
                        .map { question ->
                            QuestionWithOptins(
                                question,
                                provider.getOptionsForQ(question.id)
                            )
                        }
                        //this filtration here is wrong but i did it because of a current bug
                        .filter { questionWithOptins ->
                            questionWithOptins.options.isNotEmpty()


                        }
                //this is a workaround for the bug mentioned above
                if (xQuestionByCategorys.size != numberOfQuestions) {
                    xQuestionByCategorys.plus(provider.getRandomXQuestions(numberOfQuestions - xQuestionByCategorys.size))
                }


                state.component1().questions = xQuestionByCategorys
                initialized = true
            }

        }
    }

   suspend fun insertAttempt(question: Question, attempt: Attempt) {
        return provider.insertAttempt(question,attempt)
    }


}