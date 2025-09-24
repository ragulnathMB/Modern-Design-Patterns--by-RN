// Factory Method Java Template
interface Product {}
abstract class Creator { abstract Product factoryMethod(); }
class ConcreteProduct implements Product {}
class ConcreteCreator extends Creator { Product factoryMethod(){ return new ConcreteProduct(); } }
public class FactoryMethodTemplate { public static void main(String[] a){ Creator c = new ConcreteCreator(); c.factoryMethod(); } }
