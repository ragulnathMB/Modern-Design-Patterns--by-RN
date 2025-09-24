// Factory Method – TypeScript Template
interface Product {}
abstract class Creator { abstract factoryMethod(): Product; }
class ConcreteProduct implements Product {}
class ConcreteCreator extends Creator { factoryMethod(){ return new ConcreteProduct(); } }
