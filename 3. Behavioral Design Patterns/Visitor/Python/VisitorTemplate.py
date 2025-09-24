# Visitor Pattern – Python Template

from abc import ABC, abstractmethod

class Visitor(ABC):
    @abstractmethod
    def visit_concrete_element_a(self, element):
        pass
    
    @abstractmethod
    def visit_concrete_element_b(self, element):
        pass

class Element(ABC):
    @abstractmethod
    def accept(self, visitor):
        pass

class ConcreteElementA(Element):
    def accept(self, visitor):
        visitor.visit_concrete_element_a(self)
    
    def operation_a(self):
        return "ConcreteElementA operation"

class ConcreteElementB(Element):
    def accept(self, visitor):
        visitor.visit_concrete_element_b(self)
    
    def operation_b(self):
        return "ConcreteElementB operation"

class ConcreteVisitor1(Visitor):
    def visit_concrete_element_a(self, element):
        print(f"ConcreteVisitor1: {element.operation_a()}")
    
    def visit_concrete_element_b(self, element):
        print(f"ConcreteVisitor1: {element.operation_b()}")

class ConcreteVisitor2(Visitor):
    def visit_concrete_element_a(self, element):
        print(f"ConcreteVisitor2: {element.operation_a()}")
    
    def visit_concrete_element_b(self, element):
        print(f"ConcreteVisitor2: {element.operation_b()}")

def main():
    elements = [ConcreteElementA(), ConcreteElementB()]
    visitor = ConcreteVisitor1()
    
    for element in elements:
        element.accept(visitor)

if __name__ == "__main__":
    main()
