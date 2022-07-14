package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.model.Question
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class InsertAttempt(
    private val repository: QuestionRepo
) {
    suspend operator fun invoke(question: Question, attempt: Attempt) {
        return repository.insertAttempt(question, attempt)
    }

}