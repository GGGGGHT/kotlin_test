package com.ggggght.application.gof

import io.ktor.http.*

sealed class WaterMachineState(open val machine: WaterMachine) {
    fun turnHeating() {
        if (this !is Heating) {
            println("turn heating")
            machine.state = machine.heating
        } else {
            println("The state is already heating mode.")
        }
    }

    fun turnCooling() {
        if (this !is Cooling) {
            println("turn Cooling")
            machine.state = machine.cooling
        } else {
            println("The state is already cooling mode.")
        }
    }

    fun turnOff() {
        if (this !is Off) {
            println("turn off")
            machine.state = machine.off
        } else {
            println("The state is already off.")
        }
    }
}

class Off(override val machine: WaterMachine) : WaterMachineState(machine)
class Cooling(override val machine: WaterMachine) : WaterMachineState(machine)
class Heating(override val machine: WaterMachine) : WaterMachineState(machine)

class WaterMachine {
    var state: WaterMachineState
    val off = Off(this)
    val cooling = Cooling(this)
    val heating = Heating(this)

    init {
        state = off
    }

    fun turnHeating() {
        this.state.turnHeating()
    }

    fun turnOff() {
        this.state.turnOff()
    }

    fun turnCooling() {
        this.state.turnCooling()
    }
}

enum class Moment {
    EARLY_MORNING, DRINKING_WATER, INSTANCE_NOODLES, AFTER_WORK
}

fun waterMachineOps(machine: WaterMachine, moment: Moment) {
    when (moment) {
        Moment.EARLY_MORNING, Moment.DRINKING_WATER -> when (machine.state) {
            !is Cooling -> machine.turnCooling()
        }
        Moment.INSTANCE_NOODLES -> when (machine.state) {
            !is Heating -> machine.turnHeating()
        }
        Moment.AFTER_WORK -> when (machine.state) {
            !is Off -> machine.turnOff()
        }
    }
}

fun main(args: Array<String>) {
    val machine = WaterMachine()
//    waterMachineOps(machine, Moment.EARLY_MORNING)
    waterMachineOps(machine, Moment.DRINKING_WATER)
    waterMachineOps(machine, Moment.INSTANCE_NOODLES)
    waterMachineOps(machine, Moment.DRINKING_WATER)
    waterMachineOps(machine, Moment.AFTER_WORK)
}