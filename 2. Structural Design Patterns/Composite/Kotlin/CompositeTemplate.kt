// Composite Pattern – Kotlin Template

abstract class Component { abstract fun operation() }
class Leaf : Component() { override fun operation() { /* ... */ } }
class Composite : Component() {
    private val children = mutableListOf<Component>()
    fun add(c: Component) = children.add(c)
    fun remove(c: Component) = children.remove(c)
    override fun operation() { children.forEach { it.operation() } }
}
fun main(){ val root = Composite(); root.add(Leaf()); root.operation() }
