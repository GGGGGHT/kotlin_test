package com.ggggght.application

fun main(args: Array<String>) {
  too { return }
}

fun localReturn() {
  return
}

// 非局部返回 
inline fun too(returning: () -> Unit) {
  println("before local return")
  // localReturn()
  returning.invoke()
  println("after local return")
  return
}

