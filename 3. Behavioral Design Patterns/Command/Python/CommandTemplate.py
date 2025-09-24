# Command Pattern – Python Template

from abc import ABC, abstractmethod

class Command(ABC):
    @abstractmethod
    def execute(self):
        pass
    
    @abstractmethod
    def undo(self):
        pass

class Receiver:
    def action(self):
        return "Receiver action"
    
    def undo_action(self):
        return "Receiver undo action"

class ConcreteCommand(Command):
    def __init__(self, receiver):
        self.receiver = receiver
    
    def execute(self):
        return self.receiver.action()
    
    def undo(self):
        return self.receiver.undo_action()

class Invoker:
    def __init__(self):
        self.command = None
    
    def set_command(self, command):
        self.command = command
    
    def run(self):
        if self.command:
            return self.command.execute()
    
    def undo(self):
        if self.command:
            return self.command.undo()

def main():
    receiver = Receiver()
    command = ConcreteCommand(receiver)
    invoker = Invoker()
    invoker.set_command(command)
    print(invoker.run())
    print(invoker.undo())

if __name__ == "__main__":
    main()
