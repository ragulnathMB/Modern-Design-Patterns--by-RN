// Decorator Pattern – Kotlin Template

interface Component { fun operation() }
class ConcreteComponent : Component { override fun operation() { /* base work */ } }
open class BaseDecorator(protected val wrap: Component) : Component { override fun operation() = wrap.operation() }
class ConcreteDecoratorA(w: Component) : BaseDecorator(w) { override fun operation(){ /* extra A */ super.operation() } }
class ConcreteDecoratorB(w: Component) : BaseDecorator(w) { override fun operation(){ /* extra B */ super.operation() } }

fun main(){ val c: Component = ConcreteDecoratorB(ConcreteDecoratorA(ConcreteComponent())); c.operation() }
