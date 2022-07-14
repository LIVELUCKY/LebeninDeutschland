package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.model.Question
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class UpdateQ(
    private val repository: QuestionRepo
) {

    suspend operator fun invoke(question: Question) {
        repository.updateQ(question)
    }
}