// Iterator Pattern – Kotlin Template

interface Iterator<T> { fun hasNext(): Boolean; fun next(): T }
interface Aggregate<T> { fun createIterator(): Iterator<T> }

class ConcreteIterator<T>(private val items: List<T>) : Iterator<T> {
    private var index = 0
    override fun hasNext() = index < items.size
    override fun next() = items[index++]
}

class ConcreteAggregate<T> : Aggregate<T> {
    private val items = mutableListOf<T>()
    fun add(item: T) = items.add(item)
    override fun createIterator(): Iterator<T> = ConcreteIterator(items)
}

fun main() {
    val aggregate = ConcreteAggregate<String>()
    aggregate.add("Item1")
    aggregate.add("Item2")
    val iterator = aggregate.createIterator()
    while (iterator.hasNext()) { val item = iterator.next() }
}
