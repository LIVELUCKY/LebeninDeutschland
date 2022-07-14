package com.livelucky.lebenindeutschland.data.source

import androidx.room.*
import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.model.Category
import com.livelucky.lebenindeutschland.domain.model.Option
import com.livelucky.lebenindeutschland.domain.model.Question
import kotlinx.coroutines.flow.Flow

@Dao
interface QDao {
    @Query("SELECT * FROM questions")
    fun getAll(): Flow<List<Question>>

    @Update
    suspend fun updateQ(question: Question)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertAttempt(attempt: Attempt)

    @Delete
    suspend fun deleteAttempt(attempt: Attempt)


    @Query("DELETE  FROM attempts WHERE q_id= :question_Id")
    suspend fun deleteAllAttempts(question_Id: Long)

    @Query("SELECT * FROM options WHERE q_id = :question_Id")
    suspend fun getOptionsForQ(question_Id: Long):List<Option>

    @Query("SELECT * From questions ORDER BY RANDOM() LIMIT :x")
    suspend fun getRandomXQuestions(x: Int):List<Question>


    @Query("SELECT SUM(answer) From attempts WHERE q_id= :question_Id ")
    suspend fun getRightTimes(question_Id: Long):Int


    @Query("SELECT * FROM questions WHERE category = :category")
    suspend fun getQuestionByCategory(category: Category):List<Question>

}