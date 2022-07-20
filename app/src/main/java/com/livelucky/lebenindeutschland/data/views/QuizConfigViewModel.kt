package com.livelucky.lebenindeutschland.data.views

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.domain.use.Provider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizConfigViewModel @Inject constructor(
    private val provider: Provider
) : ViewModel() {
    val state =
        mutableStateOf(CategoryAttemptsList()) // first int ist the enum ordinal second is the total of attempts last int value right attempts
    var initialized = mutableStateOf(false)


    fun initialize() {
        if (!initialized.value) {
            viewModelScope.launch(Dispatchers.Unconfined) {
                state.value = CategoryAttemptsList(Category.values().map {
                    CategoryAttempts(
                        it,
                        provider.getAttemptsByCategory(it),
                        provider.getRightTimesByCategory(it),
                        provider.getQuestionByCategory(it).size
                    )
                }.toList())

            }
            initialized.value = true


        }
    }

}

data class CategoryAttempts(
    val category: Category,
    val attemptsTotal: Int,
    val attemptsRight: Int,
    val questions: Int
)

data class CategoryAttemptsList(val categoryAttempts: List<CategoryAttempts> = emptyList())
