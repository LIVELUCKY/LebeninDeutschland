package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.model.Option
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class GetOptionsForQ (
    private val repository: QuestionRepo
) {
    suspend operator fun invoke(question_Id: Long): List<Option> {
        return repository.getOptionsForQ(question_Id)
    }

}