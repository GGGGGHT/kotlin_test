package com.ggggght.application.concurrent

import kotlin.concurrent.thread
import kotlin.coroutines.suspendCoroutine

suspend fun main(args: Array<String>) {
  suspendFunc02("1",1)
  // thread {
  //   println(Thread.currentThread().name)
  // }
}

suspend fun suspendFunc01(a: Int) {
  return
}


suspend fun suspendFunc02(a: String, b : Int) = suspendCoroutine<Int> {  continuation ->
  thread {
    continuation.resumeWith(Result.success(b))
  }
}


