# Adapter Pattern – Python Template

from abc import ABC, abstractmethod

class Target(ABC):
    @abstractmethod
    def request(self):
        pass

class Adaptee:
    def specific_request(self):
        return "Special behavior"

class Adapter(Target):
    def __init__(self, adaptee):
        self.adaptee = adaptee
    
    def request(self):
        return f"Adapter: {self.adaptee.specific_request()}"

def main():
    adaptee = Adaptee()
    adapter = Adapter(adaptee)
    print(adapter.request())

if __name__ == "__main__":
    main()
