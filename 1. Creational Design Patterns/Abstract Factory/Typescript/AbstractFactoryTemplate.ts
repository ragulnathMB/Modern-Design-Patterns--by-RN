// Abstract Factory Pattern – TypeScript Template

// Abstract Products
interface ProductA {}
interface ProductB {}

// Concrete Products
class ConcreteProductA1 implements ProductA {}
class ConcreteProductB1 implements ProductB {}

// Abstract Factory
interface AbstractFactory {
  createProductA(): ProductA;
  createProductB(): ProductB;
}

// Concrete Factory 1
class ConcreteFactory1 implements AbstractFactory {
  createProductA() { return new ConcreteProductA1(); }
  createProductB() { return new ConcreteProductB1(); }
}

// Client Skeleton
const factory: AbstractFactory = new ConcreteFactory1();
// const productA = factory.createProductA();
