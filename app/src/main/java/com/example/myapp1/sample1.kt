fun main() {

    var car1 = Car("red", 10)
    var car2 = Car("blue", 30)
    println(car1.speed)

}

class Car {
    var color: String = ""
    var speed: Int = 0

    constructor(color: String, speed: Int) {
        this.color = color
        this.speed = speed
    }

    fun upSpeed(value: Int) {
        if (speed + value > 200) {
            speed = 200
        } else {
            speed+=value
        }
    }
    fun downSpeed(value: Int) {
        if (speed - value <= 10) {
            speed = 0
        } else {
            speed=value
        }
    }

}