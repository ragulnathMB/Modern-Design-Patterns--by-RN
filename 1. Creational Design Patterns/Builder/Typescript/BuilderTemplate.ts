// Builder Pattern – TypeScript Template
interface Product {}
interface Builder {
  buildPartA(): void;
  buildPartB(): void;
  getResult(): Product;
}
class ConcreteProduct implements Product {}
class ConcreteBuilder implements Builder {
  private product: Product = new ConcreteProduct();
  buildPartA() {}
  buildPartB() {}
  getResult() { return this.product; }
}
class Director {
  construct(b: Builder) { b.buildPartA(); b.buildPartB(); }
}
