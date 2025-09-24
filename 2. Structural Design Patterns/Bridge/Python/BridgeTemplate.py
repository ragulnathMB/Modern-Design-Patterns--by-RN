# Bridge Pattern – Python Template

from abc import ABC, abstractmethod

class Implementation(ABC):
    @abstractmethod
    def operation_impl(self):
        pass

class ConcreteImplementationA(Implementation):
    def operation_impl(self):
        return "ConcreteImplementationA operation"

class ConcreteImplementationB(Implementation):
    def operation_impl(self):
        return "ConcreteImplementationB operation"

class Abstraction:
    def __init__(self, implementation):
        self.implementation = implementation
    
    def operation(self):
        return f"Abstraction: {self.implementation.operation_impl()}"

class ExtendedAbstraction(Abstraction):
    def extended_operation(self):
        return f"ExtendedAbstraction: {self.implementation.operation_impl()}"

def main():
    impl_a = ConcreteImplementationA()
    abstraction = Abstraction(impl_a)
    print(abstraction.operation())
    
    impl_b = ConcreteImplementationB()
    extended = ExtendedAbstraction(impl_b)
    print(extended.extended_operation())

if __name__ == "__main__":
    main()
