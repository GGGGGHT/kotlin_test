package com.ggggght.application

interface Flyer {
  fun fly()
  fun kind() = "[Flyer] flying animals"
}

interface Animal {
  val name: String
  fun eat()
  fun kind() = "[Animal] flying animals"
}

class bird(override val name: String) : Animal, Flyer {
  override fun eat() {
    println("$name is eating")
  }

  override fun fly() {
    println("$name is flying")
  }

  override fun kind() = super<Flyer>.kind()
}

// fun main() {
//   val bird = bird("sparrow")
//   // bird.eat()
//   // bird.fly()
//   println(bird.kind())
// }

open class Horse {
  fun runFast() {
    println("Horse is running fast")
  }
}

open class Donkey {
  fun doLongTimeThing() {
    println("I can do some thing")
  }
}

class Mule {
  fun runFast() {
    HorseC().runFast()
  }
  fun doLongTimeThing() {
    DonkeyC().doLongTimeThing()
  }

  private inner class HorseC : Horse()
  private inner class DonkeyC : Donkey()
}

// 为什么不使用多继承 避免钻石问题
// 使用委托代替多继承

data class Dog(var weight: Double, var age: Int, var color: String) {
  var sex = 1
  operator fun component4(): Int {
    return this.sex
  }

  constructor(weight: Double, age: Int, color: String, sex: Int) : this(weight, age, color) {
    this.sex = sex
  }
}

fun main(args: Array<String>) {
  val b1 = Dog(20.1, 1, "blue", 0)
  // 将类的属性绑定到变量上
  val(weight,age,color,sex) = b1

  println(weight)
  println(age)
  println(color)
  println(sex)
  println(b1.component4())
}
