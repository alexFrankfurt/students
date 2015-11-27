package com.alex

import android.graphics.Color
import android.view.View
import org.scaloid.common._

package object style {

  def main(meToo: STextView)(implicit ctx: SContext): View PartialFunction View = {
    case b: SButton => b.textColor(Color.MAGENTA)
                        .onClick(meToo.text = "PRESSED")
    case t: STextView => t textSize 10.dip
    case e: SEditText => e.backgroundColor(Color.YELLOW).textColor(Color.BLACK)
  }
}
