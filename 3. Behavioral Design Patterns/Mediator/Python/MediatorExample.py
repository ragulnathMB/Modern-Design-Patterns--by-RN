# Mediator Pattern Example in Python
# Chat room where users send messages through a mediator

from abc import ABC, abstractmethod

class ChatRoom(ABC):
    @abstractmethod
    def send_message(self, message, user):
        pass
    
    @abstractmethod
    def add_user(self, user):
        pass

class User(ABC):
    def __init__(self, name, chat_room):
        self.name = name
        self.chat_room = chat_room
    
    @abstractmethod
    def send(self, message):
        pass
    
    @abstractmethod
    def receive(self, message, from_user):
        pass

class ConcreteUser(User):
    def send(self, message):
        self.chat_room.send_message(message, self)
    
    def receive(self, message, from_user):
        print(f"{self.name} received: {message} (from {from_user})")

class ConcreteChatRoom(ChatRoom):
    def __init__(self):
        self.users = []
    
    def add_user(self, user):
        self.users.append(user)
    
    def send_message(self, message, sender):
        for user in self.users:
            if user != sender:
                user.receive(message, sender.name)

def main():
    chat_room = ConcreteChatRoom()
    alice = ConcreteUser("Alice", chat_room)
    bob = ConcreteUser("Bob", chat_room)
    charlie = ConcreteUser("Charlie", chat_room)
    
    chat_room.add_user(alice)
    chat_room.add_user(bob)
    chat_room.add_user(charlie)
    
    alice.send("Hello everyone!")
    bob.send("Hi Alice!")

if __name__ == "__main__":
    main()
