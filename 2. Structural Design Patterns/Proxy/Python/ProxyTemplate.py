# Proxy Pattern – Python Template

from abc import ABC, abstractmethod

class Subject(ABC):
    @abstractmethod
    def request(self):
        pass

class RealSubject(Subject):
    def request(self):
        return "RealSubject: Handling request"

class Proxy(Subject):
    def __init__(self):
        self.real_subject = None
    
    def request(self):
        if self.real_subject is None:
            self.real_subject = RealSubject()
        # Add extra behavior here (access control, caching, etc.)
        return f"Proxy: {self.real_subject.request()}"

def main():
    proxy = Proxy()
    print(proxy.request())

if __name__ == "__main__":
    main()
