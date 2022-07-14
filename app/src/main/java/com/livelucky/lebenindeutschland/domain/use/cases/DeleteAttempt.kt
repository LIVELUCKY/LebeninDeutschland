package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class DeleteAttempt(
    private val repository: QuestionRepo
) {
    suspend operator fun invoke(attempt: Attempt) {
        return repository.deleteAttempt(attempt)
    }

}