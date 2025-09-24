// Bridge Pattern – Kotlin Template
// Separate Abstraction from Implementor so they can vary independently.

interface Implementor { fun opImpl() }
class ConcreteImplementorA : Implementor { override fun opImpl() { /* ... */ } }

open class Abstraction(protected val impl: Implementor) {
    open fun operation() { impl.opImpl() }
}

class RefinedAbstraction(impl: Implementor) : Abstraction(impl) {
    override fun operation() { super.operation() }
}

fun main(){ val a = RefinedAbstraction(ConcreteImplementorA()); a.operation() }
