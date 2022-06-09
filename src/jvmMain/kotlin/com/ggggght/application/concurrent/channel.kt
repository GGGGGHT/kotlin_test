package com.ggggght.application.concurrent

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.*

// By default, a "Rendezvous" channel is created.
val rendezvousChannel = Channel<String>()
val bufferedChannel = Channel<String>(10)
val conflatedChannel = Channel<String>(CONFLATED)
val unlimitedChannel = Channel<String>(UNLIMITED)

fun main() = runBlocking<Unit> {
  var jobA = launch {
    rendezvousChannel.send("A1")
    rendezvousChannel.send("A2")
    log("A done")
  }

  launch {
    rendezvousChannel.send("B1")
    log("B done")
  }

  launch {
    repeat(3) {
      val x = rendezvousChannel.receive()
      log(x)
    }
  }
}

fun log(message: Any?) {
  println("[${Thread.currentThread().name}] $message")
}