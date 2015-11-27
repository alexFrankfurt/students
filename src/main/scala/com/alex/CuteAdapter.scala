package com.alex

import android.view.{ViewGroup, View}
import android.widget.BaseAdapter
import org.scaloid.common.{TraitViewGroup, SLinearLayout, SContext, STextView}
import model.Product
import collection.mutable

class CuteAdapter(context: SContext, obs: mutable.ArrayBuffer[Product]) extends BaseAdapter {

  override def getCount = obs.length

  override def getItemId(position: Int) = position

  override def getItem(position: Int): AnyRef = obs(position)

  override def getView(position: Int, convertView: View, parent: ViewGroup): View = {
    implicit val par: TraitViewGroup[_] = parent
    implicit val ctx = context
    val elem = layout.elementView
    val tex = elem.findViewById(100).asInstanceOf[STextView]
    tex.text = getItem(position).asInstanceOf[Product].name
    elem
  }
}

object CuteAdapter {
  def apply(ctx: SContext, obs: mutable.ArrayBuffer[Product]) = new CuteAdapter(ctx, obs)
}
