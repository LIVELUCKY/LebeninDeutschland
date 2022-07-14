package com.livelucky.lebenindeutschland.domain.model.util

import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.domain.model.Option
import com.livelucky.lebenindeutschland.domain.model.Question

data class Quiz(
    var categories: List<Category> = emptyList(),
    val answeredCorrect: Int = 0,
    var questions: List<QuestionWithOptins> = emptyList()
)

data class QuestionWithOptins(val embeddedQuestion: Question, val options:List<Option>)


