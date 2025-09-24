# Abstract Factory Pattern – Python Template

from abc import ABC, abstractmethod

class AbstractProductA(ABC):
    @abstractmethod
    def operation_a(self):
        pass

class AbstractProductB(ABC):
    @abstractmethod
    def operation_b(self):
        pass

class ConcreteProductA1(AbstractProductA):
    def operation_a(self):
        return "ConcreteProductA1 operation"

class ConcreteProductB1(AbstractProductB):
    def operation_b(self):
        return "ConcreteProductB1 operation"

class ConcreteProductA2(AbstractProductA):
    def operation_a(self):
        return "ConcreteProductA2 operation"

class ConcreteProductB2(AbstractProductB):
    def operation_b(self):
        return "ConcreteProductB2 operation"

class AbstractFactory(ABC):
    @abstractmethod
    def create_product_a(self):
        pass
    
    @abstractmethod
    def create_product_b(self):
        pass

class ConcreteFactory1(AbstractFactory):
    def create_product_a(self):
        return ConcreteProductA1()
    
    def create_product_b(self):
        return ConcreteProductB1()

class ConcreteFactory2(AbstractFactory):
    def create_product_a(self):
        return ConcreteProductA2()
    
    def create_product_b(self):
        return ConcreteProductB2()

def main():
    factory1 = ConcreteFactory1()
    product_a1 = factory1.create_product_a()
    product_b1 = factory1.create_product_b()
    print(product_a1.operation_a())
    print(product_b1.operation_b())

if __name__ == "__main__":
    main()
