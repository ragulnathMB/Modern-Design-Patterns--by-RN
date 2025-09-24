// Factory Method – JavaScript Template
class Product {}
class Creator { factoryMethod(){} }
class ConcreteProduct extends Product {}
class ConcreteCreator extends Creator { factoryMethod(){ return new ConcreteProduct(); }}
