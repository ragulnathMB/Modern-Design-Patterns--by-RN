# Mediator Pattern – Python Template

from abc import ABC, abstractmethod

class Mediator(ABC):
    @abstractmethod
    def notify(self, sender, event_type):
        pass

class Colleague(ABC):
    def __init__(self, mediator):
        self.mediator = mediator

class ConcreteColleagueA(Colleague):
    def do_something(self):
        self.mediator.notify(self, "EventA")

class ConcreteColleagueB(Colleague):
    def do_something(self):
        self.mediator.notify(self, "EventB")

class ConcreteMediator(Mediator):
    def __init__(self):
        self.colleagues = []
    
    def add_colleague(self, colleague):
        self.colleagues.append(colleague)
    
    def notify(self, sender, event_type):
        print(f"Mediator handling {event_type} from {type(sender).__name__}")

def main():
    mediator = ConcreteMediator()
    colleague_a = ConcreteColleagueA(mediator)
    colleague_b = ConcreteColleagueB(mediator)
    mediator.add_colleague(colleague_a)
    mediator.add_colleague(colleague_b)
    colleague_a.do_something()

if __name__ == "__main__":
    main()
