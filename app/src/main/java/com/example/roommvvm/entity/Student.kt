package com.example.roommvvm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//class ini berfungsi untuk mengdeklarasi table student
@Entity
data class Student (
    @PrimaryKey(autoGenerate = true) var id: Int? = null,

    @ColumnInfo var name: String = ""
)