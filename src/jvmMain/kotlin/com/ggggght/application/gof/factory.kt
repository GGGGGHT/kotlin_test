package com.ggggght.application.gof

interface Computer {
    val cpu: String

    companion object ComputerFactory{
        operator fun invoke(type: ComputerType) : Computer {
            return when(type) {
                ComputerType.PC -> PC()
                ComputerType.Server -> Server()
            }
        }
    }
}

class PC(override val cpu: String = "Core") : Computer
class Server(override val cpu: String = "Xeon") : Computer

enum class ComputerType{
    PC,Server
}

object ComputerFactory {
    fun produce(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC("AMD")
            ComputerType.Server -> Server()
        }
    }

    operator fun invoke(type: ComputerType) : Computer {
        return when (type) {
            ComputerType.PC -> PC("AMD")
            ComputerType.Server -> Server()
        }
    }
}


val comp = ComputerFactory(ComputerType.PC)

fun main() {
    Computer.ComputerFactory(ComputerType.Server)
    Computer(ComputerType.Server)
    println(comp.cpu)
}