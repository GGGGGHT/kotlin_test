package com.ggggght.application.gof

import java.util.Observable
import java.util.Observer
import kotlin.properties.Delegates

//class StockUpdate : Observable() {
//    val observers = mutableSetOf<Observer>()
//
//    fun setStockChanged(price: Int) {
//        this.observers.forEach { it.update(this, price) }
//    }
//}
//
//class StockDisplay: Observer {
//    override fun update(o: Observable?, price: Any?) {
//        if (o is StockUpdate) {
//            println("The latest stock price is ${price}.")
//        }
//    }
//}

interface StockUpdateListener {
    fun onRise(price: Int)
    fun onFall(price: Int)
}

class StockDisplay : StockUpdateListener {
    override fun onRise(price: Int) {
        println("The latest stock price has risen to ${price}.")
    }

    override fun onFall(price: Int) {
        println("The latest stock price has fell to ${price}.")
    }
}

class StockUpdate {
    var listeners = mutableSetOf<StockUpdateListener>()

    var price: Int by Delegates.observable(0) { _, old, new ->
        listeners.forEach {
            if (new > old) it.onRise(price) else it.onFall(price)
        }
    }
}


var value: Int by Delegates.vetoable(0) {
        _, _, newValue ->
    newValue > 0
}


fun main(args: Array<String>) {
    val su = StockUpdate()
    val sd = StockDisplay()
    su.listeners.add(sd)
//
    su.price = 100
    su.price = 89

    value = 1;
    println("$value")
    value = -1;
    println("$value")
    value = 2;
    println("$value")
}