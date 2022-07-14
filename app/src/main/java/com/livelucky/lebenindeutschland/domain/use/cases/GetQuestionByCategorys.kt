package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.domain.model.Question
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class GetQuestionByCategorys(
    private val repository: QuestionRepo
) {
    suspend operator fun invoke(categories: List<Category>): List<Question> {
        return repository.getQuestionByCategorys(categories)
    }

}
