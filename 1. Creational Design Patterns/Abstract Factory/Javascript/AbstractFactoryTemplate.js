// Abstract Factory Pattern – JavaScript Template
// Fill concrete products & factories.

// Abstract Products
class ProductA {}
class ProductB {}

// Concrete Products
class ConcreteProductA1 extends ProductA {}
class ConcreteProductB1 extends ProductB {}

// Abstract Factory
class AbstractFactory {
  createProductA() {}
  createProductB() {}
}

// Concrete Factory 1
class ConcreteFactory1 extends AbstractFactory {
  createProductA() {
    return new ConcreteProductA1();
  }
  createProductB() {
    return new ConcreteProductB1();
  }
}

// Client Code Example
const factory = new ConcreteFactory1();
// const productA = factory.createProductA();
// const productB = factory.createProductB();
