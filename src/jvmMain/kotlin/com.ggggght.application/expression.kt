package com.ggggght.application

import java.util.Locale

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