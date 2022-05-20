package com.ggggght.application

class SmartList<T> : ArrayList<T>() {
  fun find(t: T) : T? {
    val indexOf = super.indexOf(t)
    return if(indexOf >= 0) super.get(indexOf) else null
  }
}

fun main(args: Array<String>) {
  val list = SmartList<String>()
  list.add("one")
  val l : SmartList<String> = arrayListOf("one","two") as SmartList<String>
  println(list.find("one"))
  println(list.find("tow").isNullOrEmpty())
}