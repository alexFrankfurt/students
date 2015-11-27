package com.alex

import android.content.{UriMatcher, ContentProvider, ContentValues}
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class StudentProvider extends ContentProvider {

  val MatcherCodeStudent = 1
  val uriMatcher = new UriMatcher(UriMatcher.NO_MATCH)

  uriMatcher.addURI(Authority, Table.Student, MatcherCodeStudent)

  var helper: DBHelper = null
  var db: SQLiteDatabase = null

  def onCreate(): Boolean = {
    helper = DBHelper(getContext)
    db = helper.getWritableDatabase
    true
  }

  def getType(uri: Uri): String = ???

  def update(uri: Uri,
             values: ContentValues,
             selection: String,
             selectionArgs: Array[String]): Int = ???

  def insert(uri: Uri, values: ContentValues): Uri = {

    val code = uriMatcher.`match`(uri)

    code match {
      case 1 => db.insert(Table.Student, null, values)
      case _ =>
    }

    null
  }

  def delete(uri: Uri, selection: String, selectionArgs: Array[String]): Int = ???

  def query(uri: Uri,
            projection: Array[String],
            selection: String,
            selectionArgs: Array[String],
            sortOrder: String): Cursor = {

    val code = uriMatcher.`match`(uri)

    code match {
      case 1 => db.query(Table.Student, projection, selection, selectionArgs, null, null, sortOrder)
      case _ => null
    }
  }
}

object StudentProvider {
  def apply() = new StudentProvider()
}
