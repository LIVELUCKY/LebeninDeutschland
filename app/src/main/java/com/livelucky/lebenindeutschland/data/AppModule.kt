package com.livelucky.lebenindeutschland.data

import android.app.Application
import androidx.room.Room
import com.livelucky.lebenindeutschland.data.repo.QuestionRepoImplementation
import com.livelucky.lebenindeutschland.data.source.QDB
import com.livelucky.lebenindeutschland.data.source.QDB.Companion.DATABASE_NAME
import com.livelucky.lebenindeutschland.domain.repo.QuestionRepo
import com.livelucky.lebenindeutschland.domain.use.Provider
import com.livelucky.lebenindeutschland.domain.use.cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideQDatabase(app: Application): QDB {
        return Room.databaseBuilder(
            app,
            QDB::class.java,
            DATABASE_NAME
        )
            .createFromAsset("database/question_db.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: QDB): QuestionRepo {
        return QuestionRepoImplementation(db.qDao)
    }

    @Provides
    @Singleton
    fun provideProvider(repository: QuestionRepo): Provider {
        return Provider(
            getQ = GetQ(repository),
            updateQ = UpdateQ(repository),
            insertAttempt = InsertAttempt(repository),
            deleteAllAttempts = DeleteAllAttempts(repository),
            deleteAttempt = DeleteAttempt(repository),
            getOptionsForQ = GetOptionsForQ(repository),
            getQuestionByCategory = GetQuestionByCategory(repository),
            getQuestionsOfNonStates = GetQuestionsOfNonStates(repository),
            getRightTimes = GetRightTimes(repository),
            getXQuestionByCategorys = GetXQuestionByCategorys(repository),
            getQuestionByCategorys = GetQuestionByCategorys(repository),
            getQuestionsOfStates = GetQuestionsOfStates(repository),
            getRandomQuestion = GetRandomQuestion(repository),
            getRandomXQuestions = GetRandomXQuestions(repository)
        )
    }

}