# Prototype Pattern – Python Template

import copy
from abc import ABC, abstractmethod

class Prototype(ABC):
    @abstractmethod
    def clone(self):
        pass

class ConcretePrototype(Prototype):
    def __init__(self, value):
        self.value = value
    
    def clone(self):
        return copy.deepcopy(self)
    
    def operation(self):
        return f"ConcretePrototype with value: {self.value}"

def main():
    original = ConcretePrototype("original_value")
    cloned = original.clone()
    cloned.value = "cloned_value"
    
    print(original.operation())
    print(cloned.operation())

if __name__ == "__main__":
    main()
