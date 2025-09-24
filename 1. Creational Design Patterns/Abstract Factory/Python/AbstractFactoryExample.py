# Abstract Factory Pattern Example in Python
# UI components for different operating systems

from abc import ABC, abstractmethod

# Abstract Products
class Button(ABC):
    @abstractmethod
    def render(self):
        pass

class Checkbox(ABC):
    @abstractmethod
    def render(self):
        pass

# Concrete Products - Windows
class WindowsButton(Button):
    def render(self):
        return "Rendering Windows button"

class WindowsCheckbox(Checkbox):
    def render(self):
        return "Rendering Windows checkbox"

# Concrete Products - Mac
class MacButton(Button):
    def render(self):
        return "Rendering Mac button"

class MacCheckbox(Checkbox):
    def render(self):
        return "Rendering Mac checkbox"

# Abstract Factory
class UIFactory(ABC):
    @abstractmethod
    def create_button(self):
        pass
    
    @abstractmethod
    def create_checkbox(self):
        pass

# Concrete Factories
class WindowsFactory(UIFactory):
    def create_button(self):
        return WindowsButton()
    
    def create_checkbox(self):
        return WindowsCheckbox()

class MacFactory(UIFactory):
    def create_button(self):
        return MacButton()
    
    def create_checkbox(self):
        return MacCheckbox()

class Application:
    def __init__(self, factory):
        self.factory = factory
    
    def create_ui(self):
        button = self.factory.create_button()
        checkbox = self.factory.create_checkbox()
        return f"{button.render()}, {checkbox.render()}"

def main():
    # Windows UI
    windows_app = Application(WindowsFactory())
    print("Windows UI:", windows_app.create_ui())
    
    # Mac UI
    mac_app = Application(MacFactory())
    print("Mac UI:", mac_app.create_ui())

if __name__ == "__main__":
    main()
