package com.livelucky.lebenindeutschland.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question(

    val category: Category,
    val hasImage: Boolean,
    val imageId: Int,
    val question: String,
    var rightTimes: Int = 0

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}



