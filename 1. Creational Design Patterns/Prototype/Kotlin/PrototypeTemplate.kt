// Prototype Pattern – Kotlin Template
interface Prototype<T> { fun cloneProto(): T }
class ConcretePrototype(var data: Int) : Prototype<ConcretePrototype> {
    override fun cloneProto() = ConcretePrototype(data)
}
fun main() {
    val original = ConcretePrototype(42)
    val copy = original.cloneProto()
}
