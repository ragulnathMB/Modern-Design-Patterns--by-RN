# Template Method Pattern – Python Template

from abc import ABC, abstractmethod

class AbstractClass(ABC):
    def template_method(self):
        self.step_one()
        self.step_two()
        self.hook()
    
    @abstractmethod
    def step_one(self):
        pass
    
    @abstractmethod
    def step_two(self):
        pass
    
    def hook(self):
        # Optional hook method
        pass

class ConcreteClassA(AbstractClass):
    def step_one(self):
        print("ConcreteClassA: Step 1")
    
    def step_two(self):
        print("ConcreteClassA: Step 2")

class ConcreteClassB(AbstractClass):
    def step_one(self):
        print("ConcreteClassB: Step 1")
    
    def step_two(self):
        print("ConcreteClassB: Step 2")
    
    def hook(self):
        print("ConcreteClassB: Hook")

def main():
    ConcreteClassA().template_method()
    ConcreteClassB().template_method()

if __name__ == "__main__":
    main()
