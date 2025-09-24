# Observer Pattern – Python Template

from abc import ABC, abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self):
        pass

class Subject(ABC):
    @abstractmethod
    def attach(self, observer):
        pass
    
    @abstractmethod
    def detach(self, observer):
        pass
    
    @abstractmethod
    def notify(self):
        pass

class ConcreteSubject(Subject):
    def __init__(self):
        self.observers = []
    
    def attach(self, observer):
        self.observers.append(observer)
    
    def detach(self, observer):
        self.observers.remove(observer)
    
    def notify(self):
        for observer in self.observers:
            observer.update()
    
    def do_something(self):
        # change state
        self.notify()

class ConcreteObserver(Observer):
    def update(self):
        print("ConcreteObserver: Reacted to the event")

def main():
    subject = ConcreteSubject()
    observer = ConcreteObserver()
    subject.attach(observer)
    subject.do_something()

if __name__ == "__main__":
    main()
