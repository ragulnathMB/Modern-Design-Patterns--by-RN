// Flyweight Pattern – Kotlin Template

class Flyweight { /* intrinsic, immutable data */ }

object FlyweightFactory {
    private val cache = mutableMapOf<String, Flyweight>()
    fun get(key: String): Flyweight = cache.getOrPut(key) { Flyweight() }
}

class Context(key: String) {
    private val fw = FlyweightFactory.get(key)
    fun operation(/* extrinsic params */) { /* use fw + extrinsic */ }
}

fun main(){ Context("key").operation() }
