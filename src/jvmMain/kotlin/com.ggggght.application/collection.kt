package com.ggggght.application

data class Student(val name: String, val age: Int, val sex: String, val score: Int)

val jilen = Student("Jilen",30,"m",85)
val shaw = Student("Shaw",40,"m",90)
val yison = Student("Yison",30,"m",59)
val jack = Student("Jack",30,"m",70)
val lisa = Student("Lisa",25,"f",88)
val pan = Student("Pan",36,"f",55)
var t = 10

val students = listOf(jilen, shaw, yison, jack, lisa, pan, null)

val mstudents = students.filter { it?.sex == "m" }
val fstudents = students.filterNot { it?.sex == "m" }
val notNull = students.filterNotNull()