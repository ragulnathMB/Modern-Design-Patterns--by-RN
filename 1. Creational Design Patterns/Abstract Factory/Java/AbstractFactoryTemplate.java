// Abstract Factory Pattern – Java Template
// Fill concrete products and factories for your scenario.

interface ProductA {}
interface ProductB {}

class ConcreteProductA1 implements ProductA {}
class ConcreteProductB1 implements ProductB {}

interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

class ConcreteFactory1 implements AbstractFactory {
    public ProductA createProductA() { return new ConcreteProductA1(); }
    public ProductB createProductB() { return new ConcreteProductB1(); }
}

public class AbstractFactoryTemplate {
    public static void main(String[] args) {
        // Client code here
        AbstractFactory factory = new ConcreteFactory1();
    }
}
