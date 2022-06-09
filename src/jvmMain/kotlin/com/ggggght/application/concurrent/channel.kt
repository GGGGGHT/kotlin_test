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

/**
 *
A starts
A tries to send A1 and suspends waiting for rendezvous
S = {A}, RZ = {A[A1]}
B starts
B tries to send B1 and suspends waiting for rendezvous
S = {A, B}, RZ = {A[A1], B[B1]}
C starts
C tries to receive and rendezvous with A and reads A1 from channel, hence A changes from suspension to marked for resumption
S = {B}, CC = C, MR = {A}, RZ = {B[B1]}
C prints A1
O = {A1}
C tries to receive and rendezvous with B and reads B1, when B is marked for resumption
S = {}, CC = C, MR = {A, B}, RZ = {}, O = {A1}
C prints B1
O = {A1, B1}
C tries to read and suspends as no sender called send previously
S = {C}, MR = {A, B}, RZ = {C[_]}, O = {A1, B1}
At this point, A and B are in the state marked for resumption
A is resumed
S = {C}, CC = A, MR = {B}, RZ = {C[_]}
A tries to send A2 and rendezvous with C when C is marked for resumption
S = {}, CC = A, MR = {B, C}, RZ = {A[A2]<->C[_]}, O = {A1, B1}
As A is not suspended, it prints "A done"
O = {A1, B1, A done}
A ends
E = {A}
Now B is resumed and prints "B done"
O = {A1, B1, A done, B done}
B ends
S = {}, CC = _, MR = {C}, RZ = {A[A2]]<->C[_]}, E = {A, B},
C is resumed and prints A2
S = {}, CC = C, MR = {}, RZ = {}, O = {A1, B1, A done, B done, A2}
C ends
S = {}, CC = _, MR = {}, RZ = {}, E = {A, B, C}, O = {A1, B1, A done, B done, A2}
 */
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