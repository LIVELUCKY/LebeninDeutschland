package com.livelucky.lebenindeutschland.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


@Entity(
    tableName = "options",
//    foreignKeys =
//    [
//        ForeignKey(
//            entity = Question::class,
//            parentColumns = arrayOf("imageId"),
//            childColumns = arrayOf("q_id"),
//            onDelete = CASCADE
//        )
//    ]
)
data class Option(
    val is_Correct: Boolean,
    val text: String,
    var q_id: Long = 0
) {
    @PrimaryKey(autoGenerate = true)
    var optionId: Long = 0
}
