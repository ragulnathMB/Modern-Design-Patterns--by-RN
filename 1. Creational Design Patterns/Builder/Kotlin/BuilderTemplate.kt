// Builder Pattern – Kotlin Template
class Product
interface Builder {
    fun buildPartA()
    fun buildPartB()
    fun getResult(): Product
}
class ConcreteBuilder : Builder {
    private val product = Product()
    override fun buildPartA() {}
    override fun buildPartB() {}
    override fun getResult() = product
}
class Director {
    fun construct(b: Builder) {
        b.buildPartA(); b.buildPartB()
    }
}
fun main(){
    val builder: Builder = ConcreteBuilder(); Director().construct(builder)
}
