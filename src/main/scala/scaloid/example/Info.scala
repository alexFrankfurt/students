package scaloid.example

import org.scaloid.common._

class Info extends SActivity {
  onCreate {
    contentView = new SVerticalLayout {
      STextView("Hi in new Activity!")
    }
  }
}
