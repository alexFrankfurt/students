package com.alex

import org.scaloid.common.{STextView, SLinearLayout, TraitViewGroup, SContext}

package object layout {

  def elementView(implicit ctx: SContext, pvg: TraitViewGroup[_]) = new SLinearLayout {
    STextView("jfklsf").id = 100
  }
}
