package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.model.Question
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class GetQuestionsOfStates (
    private val repository: QuestionRepo
) {
    suspend operator fun invoke(): List<Question> {
        return repository.getQuestionsOfStates()
    }

}