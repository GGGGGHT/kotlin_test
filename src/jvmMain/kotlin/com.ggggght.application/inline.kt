package com.ggggght.application

fun main() {
  bar { println("hello world!") }
}

// 3种情况下应该避免内联
// 1. 避免对具有大量函数体的函数进行内联
// 2. 一旦一个函数被定义为内联函数,便不能获取闭包类的私有成员
// 3. JVM会对普通的函数根据实际情况智能地判断是否进行内联优化,所以并不需要对其使用inline语法
inline fun bar(block: () -> Unit) {
  println("before block")
  block()
  println("after block")
}

