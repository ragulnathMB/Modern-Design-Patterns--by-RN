// Prototype Pattern – TypeScript Template
export interface Prototype<T> {
  cloneProto(): T;
}

export class ConcretePrototype implements Prototype<ConcretePrototype> {
  constructor(public data: number) {}
  cloneProto(): ConcretePrototype {
    return new ConcretePrototype(this.data);
  }
}

// Usage example (optional):
// const original = new ConcretePrototype(42);
// const copy = original.cloneProto();
