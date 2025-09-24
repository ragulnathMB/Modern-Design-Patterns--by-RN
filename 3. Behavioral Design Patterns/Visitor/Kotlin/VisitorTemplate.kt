// Visitor Pattern – Kotlin Template

interface Visitor {
    fun visit(element: ConcreteElementA)
    fun visit(element: ConcreteElementB)
}

interface Element {
    fun accept(visitor: Visitor)
}

class ConcreteElementA : Element {
    override fun accept(visitor: Visitor) = visitor.visit(this)
    fun operationA() { /* specific to A */ }
}

class ConcreteElementB : Element {
    override fun accept(visitor: Visitor) = visitor.visit(this)
    fun operationB() { /* specific to B */ }
}

class ConcreteVisitor1 : Visitor {
    override fun visit(element: ConcreteElementA) { element.operationA(); /* visitor 1 logic */ }
    override fun visit(element: ConcreteElementB) { element.operationB(); /* visitor 1 logic */ }
}

class ConcreteVisitor2 : Visitor {
    override fun visit(element: ConcreteElementA) { element.operationA(); /* visitor 2 logic */ }
    override fun visit(element: ConcreteElementB) { element.operationB(); /* visitor 2 logic */ }
}

fun main() {
    val elements: Array<Element> = arrayOf(ConcreteElementA(), ConcreteElementB())
    val visitor = ConcreteVisitor1()
    for (element in elements) element.accept(visitor)
}
