# Chain of Responsibility Pattern – Python Template

from abc import ABC, abstractmethod

class Handler(ABC):
    def __init__(self):
        self.next_handler = None
    
    def set_next(self, handler):
        self.next_handler = handler
    
    @abstractmethod
    def handle_request(self, request):
        pass

class Request:
    def __init__(self, data):
        self.data = data

class ConcreteHandlerA(Handler):
    def handle_request(self, request):
        if self.can_handle(request):
            return self.process_request(request)
        elif self.next_handler:
            return self.next_handler.handle_request(request)
        return "No handler found"
    
    def can_handle(self, request):
        return True  # condition
    
    def process_request(self, request):
        return f"ConcreteHandlerA processed: {request.data}"

class ConcreteHandlerB(Handler):
    def handle_request(self, request):
        if self.can_handle(request):
            return self.process_request(request)
        elif self.next_handler:
            return self.next_handler.handle_request(request)
        return "No handler found"
    
    def can_handle(self, request):
        return True  # condition
    
    def process_request(self, request):
        return f"ConcreteHandlerB processed: {request.data}"

def main():
    handler_a = ConcreteHandlerA()
    handler_b = ConcreteHandlerB()
    handler_a.set_next(handler_b)
    
    request = Request("test_data")
    print(handler_a.handle_request(request))

if __name__ == "__main__":
    main()
