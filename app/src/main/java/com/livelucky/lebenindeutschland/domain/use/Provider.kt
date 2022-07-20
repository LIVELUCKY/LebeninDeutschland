package com.livelucky.lebenindeutschland.domain.use

import com.livelucky.lebenindeutschland.domain.use.cases.*

data class Provider(
    val getQ: GetQ,
    val updateQ: UpdateQ,
    val insertAttempt: InsertAttempt,
    val deleteAttempt: DeleteAttempt,
    val deleteAllAttempts: DeleteAllAttempts,
    val getOptionsForQ: GetOptionsForQ,
    val getRandomXQuestions: GetRandomXQuestions,
    val getRandomQuestion: GetRandomQuestion,
    val getRightTimes: GetRightTimes,
    val getQuestionByCategory: GetQuestionByCategory,
    val getQuestionsOfStates: GetQuestionsOfStates,
    val getQuestionsOfNonStates: GetQuestionsOfNonStates,
    val getQuestionByCategorys: GetQuestionByCategorys,
    val getXQuestionByCategorys: GetXQuestionByCategorys,
    val getRightTimesByCategory:GetRightTimesByCategory,
    val getAttemptsByCategory:GetAttemptsByCategory,


)