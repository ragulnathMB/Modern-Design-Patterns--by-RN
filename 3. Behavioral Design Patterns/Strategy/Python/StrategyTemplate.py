# Strategy Pattern – Python Template

from abc import ABC, abstractmethod

class Strategy(ABC):
    @abstractmethod
    def execute(self, data):
        pass

class ConcreteStrategyA(Strategy):
    def execute(self, data):
        return f"Strategy A: {data}"

class ConcreteStrategyB(Strategy):
    def execute(self, data):
        return f"Strategy B: {data}"

class Context:
    def __init__(self, strategy):
        self.strategy = strategy
    
    def set_strategy(self, strategy):
        self.strategy = strategy
    
    def do_work(self, data):
        return self.strategy.execute(data)

def main():
    context = Context(ConcreteStrategyA())
    print(context.do_work("test"))
    context.set_strategy(ConcreteStrategyB())
    print(context.do_work("test"))

if __name__ == "__main__":
    main()
