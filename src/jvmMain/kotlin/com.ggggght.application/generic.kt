package com.ggggght.application

class SmartList<T> : ArrayList<T>() {
  fun find(t: T): T? {
    val indexOf = super.indexOf(t)
    return if (indexOf >= 0) super.get(indexOf) else null
  }
}

class Plate<T>(val t: T)
open class Fruit(val weight: Double)
class Apple(weight: Double) : Fruit(weight)
class Banana(weight: Double) : Fruit(weight)
class FruitPlate<T : Fruit>(val t: T)

fun main(args: Array<String>) {
  val list = SmartList<String>()
  list.add("one")
  val l: SmartList<String> = arrayListOf("one", "two") as SmartList<String>
  println(list.find("one"))
  println(list.find("tow").isNullOrEmpty())
}