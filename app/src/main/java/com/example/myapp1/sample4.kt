package com.example.myapp1

// ID와 이름을 가진 Person 데이터 클래스 정의
data class Person(val id: Int, val name: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return when {
            this.id != other.id -> this.id - other.id
            else -> this.name.compareTo(other.name)
        }
    }

    override fun toString(): String {
        return "($id, $name)"
    }
}

// Person 객체들의 배열을 다루는 클래스
class IntArrayClass(private val array: Array<Person>) {

    fun printArray() {
        array.forEach { println(it) }
    }

    fun isSorted(): Boolean {
        for (i in 0 until array.size - 1) {
            if (array[i] > array[i + 1]) {
                return false
            }
        }
        return true
    }

    fun sortArray(): Array<Person> {
        val sortedArray = array.copyOf()
        var temp: Person
        for (i in sortedArray.indices) {
            for (j in 0 until sortedArray.size - i - 1) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    temp = sortedArray[j]
                    sortedArray[j] = sortedArray[j + 1]
                    sortedArray[j + 1] = temp
                }
            }
        }
        return sortedArray
    }

    fun getLength(): Int {
        return array.size
    }
}

// 메인 함수 정의
fun main() {
    val people = arrayOf(
        Person(2, "Messi"),
        Person(3, "HM SON"),
        Person(1, "Ronaldo"),
        Person(2, "Mbappe")
    )

    val intArrayClass = IntArrayClass(people)

    // 원래 배열을 출력
    println("원본 배열:")
    intArrayClass.printArray()

    // 배열이 정렬되어 있는지 확인
    println("\n배열이 정렬되어 있나? ${intArrayClass.isSorted()}")

    // 배열을 정렬하고 정렬된 배열을 출력
    val sortedArray = intArrayClass.sortArray()
    println("\n정렬된 배열:")
    sortedArray.forEach { println(it) }

    println("\n내부 array가 sort되는게 아님을 증명:")
    intArrayClass.printArray()

    // 배열의 길이를 출력
    println("\n배열의 길이: ${intArrayClass.getLength()}")
}
