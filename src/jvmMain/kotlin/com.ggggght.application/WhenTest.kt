package com.ggggght.application

fun schedule(sunny: Boolean, day: Day) = when (day) {
 Day.SATURDAY -> "weekend"
 Day.SUNDAY -> "weekend"
 else -> "workday"
}