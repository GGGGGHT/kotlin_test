package com.ggggght.application

import kotlin.reflect.full.declaredMembers

data class Data(val str: String, val int: Int)


fun main() {
    val data = Data("a", 1)
//    data::class.members.forEach {
//        println(it)
//    }
    for (member in data::class.members) {
        print("${member.name} " + " -> ")
        for (parameter in member.parameters) {
            print("${parameter.type}" + " --")
        }
        println()
    }
}