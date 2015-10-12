package com.alex

import org.scaloid.common._
import model.Product
import style.main

import scala.collection.mutable


class MainActivity extends SActivity { self =>
  val data = mutable.ArrayBuffer(Product("bread"), Product("meat"))
  lazy val meToo = new STextView("Me too")

  lazy val listV = new SListView()

  implicit val loggingTag = LoggerTag("HelloLogging")

  onCreate {
    contentView = new SVerticalLayout {
//      style(main(meToo))
//      STextView("I am 10 dip tall")
//      meToo.here
//      info("Hi there")
//      STextView("I am 15 dip tall") textSize 15.dip // overriding
//      new SLinearLayout {
//        STextView("Button: ")
//        SButton(R.string.red) onClick startActivity[Info]
//        STextView(R.string.text)
//      }.wrap.here
//      SEditText("Yellow input field fills the space").fill
      val adapter = CuteAdapter(self, data)
      listV.adapter = adapter
      listV.here
      SButton("Add") onClick {
        toast("Added!")
        data += Product("meaaat!!!")
        adapter.notifyDataSetChanged()
      }
    } padding 20.dip
  }
}
