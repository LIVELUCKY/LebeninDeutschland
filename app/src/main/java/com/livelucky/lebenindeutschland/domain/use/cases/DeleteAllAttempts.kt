package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class DeleteAllAttempts(
    private val repository: QuestionRepo
) {
    suspend operator fun invoke(question_Id: Long) {
        return  repository.deleteAllAttempts(question_Id)
    }

}