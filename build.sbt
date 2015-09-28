name := "vk"

import android.Keys._
android.Plugin.androidBuild

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")
scalaVersion := "2.11.7"
scalacOptions in Compile += "-feature"

proguardCache in Android ++= Seq("org.scaloid")

proguardOptions in Android ++= Seq("-dontobfuscate"
  , "-dontoptimize", "-keepattributes Signature"
  , "-printseeds target/seeds.txt", "-printusage target/usage.txt"
  , "-dontwarn scala.collection.**" // required from Scala 2.11.4
  , "-dontwarn org.scaloid.**" // this can be omitted if current Android Build target is android-16
  , "-keep class org.scaloid.** { *; }"
  , "-dontshrink"
)

libraryDependencies += "org.scaloid" %% "scaloid" % "4.0"

libraryDependencies += aar("com.android.support" % "multidex" % "1.0.1")

dexMaxHeap in Android := "2048m"

dexMulti in Android := true

dexMinimizeMain in Android := true

dexMainClasses in Android := IO.readLines(baseDirectory.value / "MainDexList.txt")

run <<= run in Android
install <<= install in Android
