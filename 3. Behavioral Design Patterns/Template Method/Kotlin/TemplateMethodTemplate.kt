// Template Method Pattern – Kotlin Template

abstract class AbstractClass {
    fun templateMethod() { stepOne(); stepTwo(); hook() }
    protected abstract fun stepOne()
    protected abstract fun stepTwo()
    protected open fun hook() { /* optional override */ }
}

class ConcreteClassA : AbstractClass() {
    override fun stepOne() = println("A: Step 1")
    override fun stepTwo() = println("A: Step 2")
}

class ConcreteClassB : AbstractClass() {
    override fun stepOne() = println("B: Step 1")
    override fun stepTwo() = println("B: Step 2")
    override fun hook() = println("B: Hook")
}

fun main() { ConcreteClassA().templateMethod(); ConcreteClassB().templateMethod() }
