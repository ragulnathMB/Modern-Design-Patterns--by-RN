# Iterator Pattern – Python Template

from abc import ABC, abstractmethod

class Iterator(ABC):
    @abstractmethod
    def has_next(self):
        pass
    
    @abstractmethod
    def next(self):
        pass

class Aggregate(ABC):
    @abstractmethod
    def create_iterator(self):
        pass

class ConcreteIterator(Iterator):
    def __init__(self, items):
        self.items = items
        self.index = 0
    
    def has_next(self):
        return self.index < len(self.items)
    
    def next(self):
        if self.has_next():
            item = self.items[self.index]
            self.index += 1
            return item
        return None

class ConcreteAggregate(Aggregate):
    def __init__(self):
        self.items = []
    
    def add(self, item):
        self.items.append(item)
    
    def create_iterator(self):
        return ConcreteIterator(self.items)

def main():
    aggregate = ConcreteAggregate()
    aggregate.add("Item1")
    aggregate.add("Item2")
    
    iterator = aggregate.create_iterator()
    while iterator.has_next():
        item = iterator.next()
        print(item)

if __name__ == "__main__":
    main()
