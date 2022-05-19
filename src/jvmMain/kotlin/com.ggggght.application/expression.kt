package com.ggggght.application

import java.util.Locale
import kotlin.concurrent.thread

class expression {
}

// 表达式 语句
// 表达式: 可以返回值的语句
// 表达式比语句更安全
fun ifExpression(flag: Boolean) {
  val a = if (flag) "dive into Kotlin" else ""
  println(a.uppercase(Locale.getDefault()))
}

var a = 1
fun foo() = if (a > 0) {
  a++
  a
} else {
  0
}

// Unit类型 让函数调用皆为表达式
fun t () : Unit {
  val mayBeInt: Int? = null
  print( mayBeInt ?: 1)
}

fun printLetters(vararg letters: String, count : Int) {
  print("$count letters: ")
  for(letter in letters) print(letter)
}

fun main() {
  // printLetters("a", "b", "c", count = 3)
  // val letters = arrayOf("a", "b", "c")
  // printLetters(*letters, count = 3)
  val person = Person()
  // 中缀表达式
  person.called("haha")
  person called "test"
  // JEP326
  val rawString = """
    \n Kotlin is awesome
    \n Kotlin is a better Java."""
  println(rawString)
  println(message("ght", "USA"))
  println("Kotlin has ${if ("Kotlin".length > 0) "Kotlin".length else "no" } letters.")
  val task = {
    println("c")
  }
  println("a")
  thread(block = task)
  println("b")

}

class Person {
  infix fun called(name: String) {
    println("My name is $name")
  }
}

fun message(name: String, lang: String) = "hi $name, welcome to $lang!"

