package com.alex

import com.alex.activity.Info
import com.alex.mixin.PersonTableActable
import org.scaloid.common._
import model.Product
import style.main

import scala.collection.mutable


class MainActivity extends SActivity with PersonTableActable { self =>
  val data = mutable.ArrayBuffer(Product("bread"), Product("meat"), Product("but"), Product("cool"))
  lazy val meToo = new STextView("Me too")

  lazy val listV = new SListView()

  implicit val loggingTag = LoggerTag("HelloLogging")

  onCreate {
    contentView = new SVerticalLayout {
      new SLinearLayout {
        STextView("Button: ")
        SButton(R.string.red) onClick startActivity[Info]
        STextView(R.string.text)
      }.wrap.here

      val adapter = CuteAdapter(self, data)
      listV.adapter = adapter
      listV.here
      SButton("Add") onClick {
        toast("Added!")
        data += Product("meaaat!!!")
        adapter.notifyDataSetChanged()
        contentResolver
      }
      SButton("add student") onClick insertStudent(student)
      SButton("show students") onClick toast(queryStudents())
    } padding 20.dip
  }
}
