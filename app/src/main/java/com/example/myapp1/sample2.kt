package com.example.myapp1

fun main() {
    println(car1.speed)
    println(car1.color)
    println(car2.speed)
    println(car2.color)

}

class Car(var speed: Int) {
    var color: String = "empty"

    constructor(speed: Int, color: String) : this(speed){
        this.color = color
    }

    fun upSpeed(value: Int) {
        speed += value
    }
    fun downSpeed(value: Int) {
        speed -= value
    }

}

var car1 = Car(10, "red")
var car2 = Car(10)
