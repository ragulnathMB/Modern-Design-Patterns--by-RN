# Decorator Pattern Example in Python
# Notifier: Basic + Email + SMS + Slack decorators

from abc import ABC, abstractmethod

class Notifier(ABC):
    @abstractmethod
    def send(self, message):
        pass

class BasicNotifier(Notifier):
    def send(self, message):
        return f"Base notify: {message}"

class NotifierDecorator(Notifier):
    def __init__(self, notifier):
        self.notifier = notifier
    
    def send(self, message):
        return self.notifier.send(message)

class EmailDecorator(NotifierDecorator):
    def send(self, message):
        result = f"Email sent: {message}"
        base_result = super().send(message)
        return f"{result}\n{base_result}"

class SMSDecorator(NotifierDecorator):
    def send(self, message):
        result = f"SMS sent: {message}"
        base_result = super().send(message)
        return f"{result}\n{base_result}"

class SlackDecorator(NotifierDecorator):
    def send(self, message):
        result = f"Slack message sent: {message}"
        base_result = super().send(message)
        return f"{result}\n{base_result}"

def main():
    notifier = BasicNotifier()
    notifier = EmailDecorator(notifier)
    notifier = SMSDecorator(notifier)
    notifier = SlackDecorator(notifier)
    print(notifier.send("System maintenance at 2 AM"))

if __name__ == "__main__":
    main()
