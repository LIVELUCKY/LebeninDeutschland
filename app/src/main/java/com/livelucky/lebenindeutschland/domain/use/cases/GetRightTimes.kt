package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class GetRightTimes(
    private val repository: QuestionRepo
) {
    suspend operator fun invoke(question_Id: Long): Int {
        return repository.getRightTimes(question_Id)
    }

}
