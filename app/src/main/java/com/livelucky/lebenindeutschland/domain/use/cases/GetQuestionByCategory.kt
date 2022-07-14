package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.domain.model.Question
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class GetQuestionByCategory(
    private val repository: QuestionRepo
) {
    suspend operator fun invoke(category: Category): List<Question> {
        return repository.getQuestionByCategory(category)
    }

}