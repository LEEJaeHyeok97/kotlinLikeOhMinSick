import java.util.*

fun main() {
    doWhen(1)
    doWhen("DiMo")
    doWhen(123L)
    doWhen(true)
    doWhen("adas")
}

fun doWhen(a: Any) {
    when (a) {
        1 -> println("정수 1입니다.")
        "DiMo" -> println("디모의 코틀린 강좌입니다.")
        is Long -> println("Long 타입입니다.")
        !is String -> println("String 타입이 아닙니다.")
        else -> println("어떤 조건도 만족하지 않습니다.")
    }
}