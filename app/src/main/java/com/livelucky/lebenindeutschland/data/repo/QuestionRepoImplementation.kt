package com.livelucky.lebenindeutschland.data.repo

import com.livelucky.lebenindeutschland.data.source.QDao
import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.domain.model.Option
import com.livelucky.lebenindeutschland.domain.model.Question
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo
import kotlinx.coroutines.flow.Flow

class QuestionRepoImplementation(
    private val qDao: QDao
) : QuestionRepo {

    override fun getAll(): Flow<List<Question>> {
        return qDao.getAll()
    }

    override suspend fun updateQ(question: Question) {
        qDao.updateQ(question)
    }

    override suspend fun insertAttempt(question: Question, attempt: Attempt) {
        attempt.q_id = question.id
        qDao.insertAttempt(attempt)
    }

    override suspend fun deleteAttempt(attempt: Attempt) {
        qDao.deleteAttempt(attempt)
    }

    override suspend fun deleteAllAttempts(question_Id: Long) {
        qDao.deleteAllAttempts(question_Id)
    }

    override suspend fun getOptionsForQ(question_Id: Long): List<Option> {
        return qDao.getOptionsForQ(question_Id)
    }

    override suspend fun getRandomXQuestions(x: Int): List<Question> {
        return qDao.getRandomXQuestions(x)
    }

    override suspend fun getRandomQuestion(): Question {
        return getRandomXQuestions(1)[0]
    }

    override suspend fun getRightTimes(question_Id: Long): Int {
        return qDao.getRightTimes(question_Id)
    }

    override suspend fun getQuestionByCategory(category: Category): List<Question> {
        return qDao.getQuestionByCategory(category)
    }

    override suspend fun getQuestionsOfStates(): List<Question> {
        return Category.states().map { category: Category -> getQuestionByCategory(category) }
            .flatten()
    }

    override suspend fun getQuestionsOfNonStates(): List<Question> {
        return Category.nonStates().map { category: Category -> getQuestionByCategory(category) }
            .flatten()
    }

    override suspend fun getQuestionByCategorys(categories: List<Category>): List<Question> {
        return categories.map { category: Category -> getQuestionByCategory(category) }.flatten()
    }

    override suspend fun getXQuestionByCategorys(
        x: Int,
        categories: List<Category>
    ): List<Question> {
        return categories.map { category: Category -> getQuestionByCategory(category) }.flatten()
            .shuffled().take(x)

    }

    override suspend fun getRightTimesByCategory(category: Category): Int {
        return qDao.getAttemptsByCategory(category).filter { it.answer }.size
    }

    override suspend fun getAttemptsByCategory(category: Category): Int {
        return qDao.getAttemptsByCategory(category).size

    }


}