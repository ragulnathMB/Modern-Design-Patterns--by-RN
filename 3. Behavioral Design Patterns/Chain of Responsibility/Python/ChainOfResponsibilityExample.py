# Chain of Responsibility Pattern Example in Python
# Support ticket system with different levels of handlers

from abc import ABC, abstractmethod

class SupportHandler(ABC):
    def __init__(self):
        self.next_handler = None
    
    def set_next(self, handler):
        self.next_handler = handler
    
    @abstractmethod
    def handle_request(self, ticket):
        pass

class SupportTicket:
    def __init__(self, issue, priority):
        self.issue = issue
        self.priority = priority

class Level1Support(SupportHandler):
    def handle_request(self, ticket):
        if ticket.priority <= 1:
            return f"Level 1: Handled '{ticket.issue}'"
        elif self.next_handler:
            return self.next_handler.handle_request(ticket)
        else:
            return f"No handler available for '{ticket.issue}'"

class Level2Support(SupportHandler):
    def handle_request(self, ticket):
        if ticket.priority <= 2:
            return f"Level 2: Handled '{ticket.issue}'"
        elif self.next_handler:
            return self.next_handler.handle_request(ticket)
        else:
            return f"No handler available for '{ticket.issue}'"

class Level3Support(SupportHandler):
    def handle_request(self, ticket):
        return f"Level 3: Handled '{ticket.issue}'"

def main():
    level1 = Level1Support()
    level2 = Level2Support()
    level3 = Level3Support()
    
    level1.set_next(level2)
    level2.set_next(level3)
    
    tickets = [
        SupportTicket("Password reset", 1),
        SupportTicket("Software bug", 2),
        SupportTicket("System crash", 3)
    ]
    
    for ticket in tickets:
        print(level1.handle_request(ticket))

if __name__ == "__main__":
    main()
