package com.ggggght.application

import kotlin.properties.Delegates

class Bird(
  val weight: Double,
  val age: Int,
  val color: String
) {
  // val weight: Double
  // val age: Int
  // val color: String

  // lazy must be val not var
  // only by first called will be initialized
  // lazy will add lock,so it is thread safe
  val sex: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { if (this.color == "yellow") "male" else "female" }

  lateinit var test: String

  fun printTest() {
    test = if(this.color == "yellow") "haha" else "hehe"
    println("$test}")
  }
  init {
    // this.weight = weight
    // this.age = age
    // this.color = color
    println("do some other things")
    println("this weight is $weight")
  }

  fun printSex() {
  }

  var tt by Delegates.notNull<Int>()

  fun doSomething() {
    tt = 1
    println("tt value is ${tt}")
    tt = 2
  }
}