package com.ggggght.application.concurrent

import kotlinx.coroutines.*

// runBlock和coroutineScope的区别
// runBlock是协程的一个抽象，coroutineScope是协程的一个实现
// runBlock方法阻塞当前线程等待协程执行完毕，coroutineScope方法不会阻塞当前线程，而是在协程执行完毕后，自动回收协程
// runBlock方法是阻塞的，coroutineScope方法是非阻塞的
// runBlock是一个常规函数，coroutineScope是一个挂起函数
fun main() = runBlocking {
  doWorld()
  println("done")



 val job = launch {
   delay(1000L)
   println("a new job!")
 }
  println("main.")
  // job.cancel()
  job.join()
  println("Done.")
}

// 创建一个协程范围 在所有的子进程完成之前不会完成
suspend fun doWorld() = coroutineScope {
  launch {
    delay(1000L)
    println("World 1!")
  }

  launch { // 子协程
    delay(2000L)
    println("World 2")
  }

  println("Hello,")
}
