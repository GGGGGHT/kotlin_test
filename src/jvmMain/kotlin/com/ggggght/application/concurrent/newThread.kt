package com.ggggght.application.concurrent

import kotlin.concurrent.thread

// use conutdownlatch
fun main(args: Array<String>) {
  thread {
    println(Thread.currentThread().name)
  }
}
