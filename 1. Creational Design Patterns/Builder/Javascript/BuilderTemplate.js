// Builder Pattern – JavaScript Template
class Product {}
class Builder {
  buildPartA() {}
  buildPartB() {}
  getResult() {}
}
class ConcreteBuilder extends Builder {
  constructor() { super(); this.product = new Product(); }
  buildPartA() {}
  buildPartB() {}
  getResult() { return this.product; }
}
class Director {
  construct(builder) {
    builder.buildPartA();
    builder.buildPartB();
  }
}
