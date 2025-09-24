# Decorator Pattern – Python Template

from abc import ABC, abstractmethod

class Component(ABC):
    @abstractmethod
    def operation(self):
        pass

class ConcreteComponent(Component):
    def operation(self):
        return "ConcreteComponent operation"

class BaseDecorator(Component):
    def __init__(self, component):
        self.component = component
    
    def operation(self):
        return self.component.operation()

class ConcreteDecoratorA(BaseDecorator):
    def operation(self):
        return f"ConcreteDecoratorA({super().operation()})"

class ConcreteDecoratorB(BaseDecorator):
    def operation(self):
        return f"ConcreteDecoratorB({super().operation()})"

def main():
    component = ConcreteComponent()
    decorated = ConcreteDecoratorB(ConcreteDecoratorA(component))
    print(decorated.operation())

if __name__ == "__main__":
    main()
