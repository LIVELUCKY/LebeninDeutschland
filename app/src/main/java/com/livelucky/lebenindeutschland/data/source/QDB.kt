package com.livelucky.lebenindeutschland.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.livelucky.lebenindeutschland.domain.model.Attempt
import com.livelucky.lebenindeutschland.domain.model.Option
import com.livelucky.lebenindeutschland.domain.model.Question

@Database(entities = [Question::class, Attempt::class,Option::class], version = 1, exportSchema = false)
abstract class QDB : RoomDatabase() {
    abstract val qDao: QDao

    companion object {
        const val DATABASE_NAME = "question_db"
    }
}