package com.livelucky.lebenindeutschland.domain.repo

import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.domain.model.Option
import com.livelucky.lebenindeutschland.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepo {
    fun getAll(): Flow<List<Question>>

    suspend fun updateQ(question: Question)

    suspend fun insertAttempt(question: Question, attempt: Attempt)

    suspend fun deleteAttempt(attempt: Attempt)

    suspend fun deleteAllAttempts(question_Id: Long)

    suspend fun getOptionsForQ(question_Id: Long):List<Option>

    suspend fun getRandomXQuestions(x: Int):List<Question>

    suspend fun getRandomQuestion():Question

    suspend fun getRightTimes(question_Id: Long):Int

    suspend fun getQuestionByCategory(category: Category):List<Question>

    suspend fun getQuestionsOfStates():List<Question>
    suspend fun getQuestionsOfNonStates():List<Question>

    suspend fun getQuestionByCategorys(categories: List<Category>):List<Question>

    suspend fun getXQuestionByCategorys(x:Int,categories: List<Category>):List<Question>

    suspend fun getRightTimesByCategory(category: Category):Int

    suspend fun getAttemptsByCategory(category: Category):Int


}