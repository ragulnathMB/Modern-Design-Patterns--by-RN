// Visitor Pattern – JavaScript Template

class Visitor {
  visitConcreteElementA(element) {}
  visitConcreteElementB(element) {}
}

class Element {
  accept(visitor) {}
}

class ConcreteElementA extends Element {
  accept(visitor) { visitor.visitConcreteElementA(this) }
  operationA() { /* specific to A */ }
}

class ConcreteElementB extends Element {
  accept(visitor) { visitor.visitConcreteElementB(this) }
  operationB() { /* specific to B */ }
}

class ConcreteVisitor1 extends Visitor {
  visitConcreteElementA(element) { element.operationA(); /* visitor 1 logic */ }
  visitConcreteElementB(element) { element.operationB(); /* visitor 1 logic */ }
}

class ConcreteVisitor2 extends Visitor {
  visitConcreteElementA(element) { element.operationA(); /* visitor 2 logic */ }
  visitConcreteElementB(element) { element.operationB(); /* visitor 2 logic */ }
}

;(function main() {
  const elements = [new ConcreteElementA(), new ConcreteElementB()]
  const visitor = new ConcreteVisitor1()
  for (const element of elements) element.accept(visitor)
})()
