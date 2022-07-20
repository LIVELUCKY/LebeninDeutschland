package com.livelucky.lebenindeutschland.domain.use

import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.domain.model.Question
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo

class GetRightTimesByCategory (
    private val repository: QuestionRepo
) {
    suspend operator fun invoke(category: Category): Int {
        return repository.getRightTimesByCategory(category)
    }

}