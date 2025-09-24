// Visitor Pattern – TypeScript Template

interface Visitor {
  visitConcreteElementA(element: ConcreteElementA): void
  visitConcreteElementB(element: ConcreteElementB): void
}

interface Element {
  accept(visitor: Visitor): void
}

class ConcreteElementA implements Element {
  accept(visitor: Visitor): void { visitor.visitConcreteElementA(this) }
  operationA(): void { /* specific to A */ }
}

class ConcreteElementB implements Element {
  accept(visitor: Visitor): void { visitor.visitConcreteElementB(this) }
  operationB(): void { /* specific to B */ }
}

class ConcreteVisitor1 implements Visitor {
  visitConcreteElementA(element: ConcreteElementA): void { element.operationA(); /* visitor 1 logic */ }
  visitConcreteElementB(element: ConcreteElementB): void { element.operationB(); /* visitor 1 logic */ }
}

class ConcreteVisitor2 implements Visitor {
  visitConcreteElementA(element: ConcreteElementA): void { element.operationA(); /* visitor 2 logic */ }
  visitConcreteElementB(element: ConcreteElementB): void { element.operationB(); /* visitor 2 logic */ }
}

;(function main() {
  const elements: Element[] = [new ConcreteElementA(), new ConcreteElementB()]
  const visitor = new ConcreteVisitor1()
  for (const element of elements) element.accept(visitor)
})()

export {}
