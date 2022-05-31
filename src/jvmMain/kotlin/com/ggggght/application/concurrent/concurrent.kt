package com.ggggght.application.concurrent

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
  // var job = launch {
  //   delay(1000)
  //   println("World!")
  // }
  //
  // print("Hello,")
  // job.join()
  val timeNonBlock = measureTimeMillis {
    val one = async { searchIemOne() }
    val two = async { searchItemTwo() }
    println("The answer is ${one.await()} + ${two.await()}")
  }

  val timeBlock = measureTimeMillis {
    val one = searchIemOne()
    val two = searchItemTwo()
    println("The answer is $one + $two")
  }

  println("block Cost time is $timeBlock ms")
  println("nonblock Cost time is $timeNonBlock ms")
}

suspend fun searchIemOne(): String {
  delay(1000)

  return "item-one"
}

suspend fun searchItemTwo(): String {
  delay(1000)

  return "item-two"
}