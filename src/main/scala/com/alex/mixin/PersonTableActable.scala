package com.alex.mixin

import android.content.ContentValues
import com.alex._
import com.alex.model.Student
import org.scaloid.common.SContext

trait PersonTableActable { self: SContext =>

  val student = Student("Alex", "Amsel")

  def insertStudent(student: Student) = {
    val values = new ContentValues()

    values.put(Column.Name, student.name)
    values.put(Column.Surname, student.surname)

    contentResolver.insert(ContentUriStudent, values)
  }

  def queryStudents(): String = {
    import Column._
    val projection = Array(Name, Surname)
    val cursor = contentResolver.query(ContentUriStudent, projection, null, null, null)

    val sb = new StringBuilder()

    cursor.moveToFirst()
    while (!cursor.isAfterLast) {
      sb.append(
        Student(
          cursor.getString(cursor.getColumnIndex(Name)),
          cursor.getString(cursor.getColumnIndex(Surname))
        )
      ).append('\n')

      cursor.moveToNext()
    }

    cursor.close()

    sb.toString()
  }
}
