// Strategy Pattern Example in Kotlin
// Sorter with BubbleSort and QuickSort strategies

interface SortStrategy { fun sort(data: List<Int>): List<Int> }

class BubbleSort : SortStrategy {
    override fun sort(data: List<Int>): List<Int> {
        val arr = data.toMutableList()
        for (i in arr.indices) {
            for (j in 0 until arr.size - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    val tmp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = tmp
                }
            }
        }
        println("BubbleSort used")
        return arr
    }
}

class QuickSort : SortStrategy {
    override fun sort(data: List<Int>): List<Int> {
        val arr = data.toMutableList()
        arr.sort() // brevity
        println("QuickSort used")
        return arr
    }
}

class Sorter(private var strategy: SortStrategy) {
    fun setStrategy(s: SortStrategy) { strategy = s }
    fun sort(data: List<Int>) = strategy.sort(data)
}

fun main(){
    val data = listOf(5,2,9,1,5,6)
    val sorter = Sorter(BubbleSort())
    println(sorter.sort(data))
    sorter.setStrategy(QuickSort())
    println(sorter.sort(data))
}
