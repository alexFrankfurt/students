package com.alex

import android.content.Context
import android.database.sqlite.{SQLiteDatabase, SQLiteOpenHelper}
import SQLiteDatabase.CursorFactory

class DBHelper(
    ctx: Context,
    name: String,
    factory: CursorFactory,
    version: Int)
  extends SQLiteOpenHelper(ctx, name, factory, version) {
  import DBHelper._

  def onCreate(db: SQLiteDatabase): Unit = {
    db.execSQL(CreatePersonScript)
  }

  def onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int): Unit = ???
}

object DBHelper {
  private val CreatePersonScript = {
    import Column._
    "create table " + Table.Student + " ( " +
      Id + " integer primary key autoincrement," +
      Name + " text," +
      Surname + " text);"

    s"""create table ${Table.Student} (
       |$Id      integer primary key autoincrement,
       |$Name    text,
       |$Surname text);"
     """.stripMargin
  }

  def apply(ctx: Context) = new DBHelper(ctx, "person.sqlite", null, 1)
}
