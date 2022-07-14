package com.livelucky.lebenindeutschland.domain.use.cases

import com.livelucky.lebenindeutschland.domain.model.Question
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo
import kotlinx.coroutines.flow.Flow

class GetQ(
    private val repository: QuestionRepo
) {
    operator fun invoke() : Flow<List<Question>> {
        return  repository.getAll()
    }

}