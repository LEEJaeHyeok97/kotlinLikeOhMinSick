package com.example.myapp1

data class Student(val id: Int, val name: String) : Comparable<Student> {
    override fun compareTo(other: Student): Int =
        if (this.id != other.id) this.id - other.id else this.name.compareTo(other.name)
}

class MaxHeap {
    private val students: MutableList<Student> = mutableListOf()

    private fun heapify(index: Int) {
        var largest = index
        val left = 2 * index + 1
        val right = 2 * index + 2

        if (left < students.size && students[left] > students[largest]) {
            largest = left
        }

        if (right < students.size && students[right] > students[largest]) {
            largest = right
        }

        if (largest != index) {
            val swap = students[index]
            students[index] = students[largest]
            students[largest] = swap
            heapify(largest)
        }
    }

    fun buildHeap(items: Array<Student>) {
        students.addAll(items)
        for (i in students.size / 2 - 1 downTo 0) {
            heapify(i)
        }
    }

    fun push(item: Student) {
        students.add(item)
        var i = students.size - 1
        while (i != 0 && students[(i - 1) / 2] < students[i]) {
            val temp = students[i]
            students[i] = students[(i - 1) / 2]
            students[(i - 1) / 2] = temp
            i = (i - 1) / 2
        }
    }

    fun pop(): Student? {
        return if (students.isNotEmpty()) {
            val popped = students[0]
            students[0] = students.last()
            students.removeAt(students.size - 1)
            heapify(0)
            popped
        } else null
    }

    fun toArray(): Array<Student> = students.toTypedArray()
}

class Arr(private val students: Array<Student>) {
    fun printArr() = students.forEach { println("${it.id}, ${it.name}") }

    fun isSorted(): Boolean {
        for (i in 0 until students.size - 1) {
            if (students[i] > students[i + 1]) {
                return false
            }
        }
        return true
    }

    fun sort(method: String): Array<Student> {
        val copiedArray = students.copyOf()
        when (method) {
            "heap" -> {
                val heap = MaxHeap()
                heap.buildHeap(copiedArray)
                for (i in copiedArray.indices.reversed()) {
                    copiedArray[i] = heap.pop()!!
                }
            }
            "quick" -> quickSort(copiedArray, 0, copiedArray.size - 1)
            "selection" -> selectionSort(copiedArray)
        }
        return copiedArray
    }

    private fun quickSort(arr: Array<Student>, low: Int, high: Int) {
        if (low < high) {
            val pi = partition(arr, low, high)
            quickSort(arr, low, pi - 1)
            quickSort(arr, pi + 1, high)
        }
    }

    private fun partition(arr: Array<Student>, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = (low - 1)

        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++


                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }


        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp

        return i + 1
    }

    private fun selectionSort(arr: Array<Student>) {
        for (i in arr.indices) {
            var minIdx = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j
                }
            }
            val temp = arr[minIdx]
            arr[minIdx] = arr[i]
            arr[i] = temp
        }
    }
}

fun main() {
    val random = java.util.Random()
    val students = Array(1000) { Student(random.nextInt(10000), "Student${it + 1}") }
    val arr = Arr(students)

    println("원본 array:")
    arr.printArr()

    println("\n힙정렬:")
    val sortedWithHeap = Arr(arr.sort("heap"))
    println("Is sorted: ${sortedWithHeap.isSorted()}")

    println("\n퀵 정렬:")
    val sortedWithQuick = Arr(arr.sort("quick"))
    println("Is sorted: ${sortedWithQuick.isSorted()}")

    println("\n선택 정렬:")
    val sortedWithSelection = Arr(arr.sort("selection"))
    println("Is sorted: ${sortedWithSelection.isSorted()}")
}
