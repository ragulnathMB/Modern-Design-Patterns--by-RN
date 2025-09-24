// Bridge Pattern – JavaScript Template
// Separate Abstraction from Implementor so they can vary independently.

class Implementor { opImpl() {} }
class ConcreteImplementorA extends Implementor { opImpl() { /* ... */ } }

class Abstraction {
  constructor(impl) { this.impl = impl; }
  operation() { this.impl.opImpl(); }
}

class RefinedAbstraction extends Abstraction {
  operation() { super.operation(); }
}

// Usage: new RefinedAbstraction(new ConcreteImplementorA()).operation();
