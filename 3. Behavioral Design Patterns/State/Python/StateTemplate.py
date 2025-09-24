# State Pattern – Python Template

from abc import ABC, abstractmethod

class State(ABC):
    @abstractmethod
    def handle(self, context):
        pass

class Context:
    def __init__(self, initial_state):
        self.state = initial_state
    
    def set_state(self, state):
        self.state = state
    
    def request(self):
        self.state.handle(self)

class ConcreteStateA(State):
    def handle(self, context):
        print("ConcreteStateA handling request")
        context.set_state(ConcreteStateB())

class ConcreteStateB(State):
    def handle(self, context):
        print("ConcreteStateB handling request")
        context.set_state(ConcreteStateA())

def main():
    context = Context(ConcreteStateA())
    context.request()
    context.request()

if __name__ == "__main__":
    main()
