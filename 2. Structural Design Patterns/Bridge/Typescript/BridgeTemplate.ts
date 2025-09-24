// Bridge Pattern – TypeScript Template
// Separate Abstraction from Implementor so they can vary independently.

declare const console: any;

interface Implementor {
  opImpl(): void;
}

class ConcreteImplementorA implements Implementor {
  opImpl(): void { /* ... */ }
}

class Abstraction {
  constructor(protected impl: Implementor) {}
  operation(): void { this.impl.opImpl(); }
}

class RefinedAbstraction extends Abstraction {
  operation(): void { super.operation(); }
}

// Usage: new RefinedAbstraction(new ConcreteImplementorA()).operation();
