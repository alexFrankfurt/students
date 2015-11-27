package com

import _root_.android.content.ContentValues
import _root_.android.net.Uri
import com.alex.model.Student

package object alex {

  lazy val Authority = "com.alex"
  private lazy val Content = "content://"
  lazy val ContentUri = Uri.parse(Content + Authority)

  lazy val PathStudent = "student"
  lazy val ContentUriStudent = Uri.parse(Content + Authority + "/" + PathStudent)//Uri.withAppendedPath(ContentUri, PathStudent)

  object Table {
    lazy val Student = "student"
  }

  object Column {
    lazy val Id = "id"
    lazy val Name = "name"
    lazy val Surname = "surname"
  }

  def insertStudent() = {
    val st = Student("Alex", "Amsel")
    val values = new ContentValues()
  }
}
