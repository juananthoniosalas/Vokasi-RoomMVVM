package com.example.roommvvm.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roommvvm.entity.Student

@Dao
interface StudentDao {
    //untuk menampilkan data student
    @Query("Select * from student")
    fun getAll(): List<Student>

    //untuk menambah data
    @Insert
    fun insertStudent(item: Student)
}