package com.alex

import org.scaloid.common._

class Info extends SActivity {
  onCreate {
    contentView = new SVerticalLayout {
      STextView("Hi in new Activity!")
    }
  }
}
