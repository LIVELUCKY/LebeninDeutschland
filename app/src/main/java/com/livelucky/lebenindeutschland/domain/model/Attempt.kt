package com.livelucky.lebenindeutschland.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity(
    tableName = "attempts",
    foreignKeys =
    [
        ForeignKey(
            entity = Question::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("q_id"),
            onDelete = CASCADE
        )
    ]
)
data class Attempt(

    val answer: Boolean,
    val time: String = SimpleDateFormat(
        "dd/MM/yyyy HH:mm",
        Locale.getDefault()
    ).format(Date()),

    var q_id: Long = 0
) {
    @PrimaryKey(autoGenerate = true)
    var attemptId: Long = 0
}