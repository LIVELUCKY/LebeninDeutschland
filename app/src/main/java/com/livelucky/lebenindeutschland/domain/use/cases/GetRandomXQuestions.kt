package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.model.Question
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class GetRandomXQuestions(
    private val repository: QuestionRepo
) {
    suspend operator fun invoke(x: Int): List<Question> {
        return repository.getRandomXQuestions(x)
    }

}
