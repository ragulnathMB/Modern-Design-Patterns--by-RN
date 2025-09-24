// Abstract Factory Pattern – Kotlin Template

interface ProductA
interface ProductB

class ConcreteProductA1 : ProductA
class ConcreteProductB1 : ProductB

interface AbstractFactory {
    fun createProductA(): ProductA
    fun createProductB(): ProductB
}

class ConcreteFactory1 : AbstractFactory {
    override fun createProductA() = ConcreteProductA1()
    override fun createProductB() = ConcreteProductB1()
}

fun main() {
    val factory: AbstractFactory = ConcreteFactory1()
    // val productA = factory.createProductA()
}
