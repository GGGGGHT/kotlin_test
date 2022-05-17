package com.ggggght.application

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
  val sex: String by lazy { if (this.color == "yellow") "male" else "female" }

  init {
    // this.weight = weight
    // this.age = age
    // this.color = color
    println("do some other things")
    println("this weight is $weight")
  }

  fun printSex() {
  }
}