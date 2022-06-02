package com.ggggght.application.concurrent

import kotlin.concurrent.thread

fun main(args: Array<String>) {
  thread {
    println(Thread.currentThread().name)
  }
}