# Command Pattern Example in Python
# Remote control executes commands on Light and Stereo

from abc import ABC, abstractmethod

class Command(ABC):
    @abstractmethod
    def execute(self):
        pass
    
    @abstractmethod
    def undo(self):
        pass

class Light:
    def on(self):
        return "Light ON"
    
    def off(self):
        return "Light OFF"

class Stereo:
    def on(self):
        return "Stereo ON"
    
    def off(self):
        return "Stereo OFF"

class LightOnCommand(Command):
    def __init__(self, light):
        self.light = light
    
    def execute(self):
        return self.light.on()
    
    def undo(self):
        return self.light.off()

class LightOffCommand(Command):
    def __init__(self, light):
        self.light = light
    
    def execute(self):
        return self.light.off()
    
    def undo(self):
        return self.light.on()

class StereoOnCommand(Command):
    def __init__(self, stereo):
        self.stereo = stereo
    
    def execute(self):
        return self.stereo.on()
    
    def undo(self):
        return self.stereo.off()

class StereoOffCommand(Command):
    def __init__(self, stereo):
        self.stereo = stereo
    
    def execute(self):
        return self.stereo.off()
    
    def undo(self):
        return self.stereo.on()

class RemoteButton:
    def __init__(self, command):
        self.command = command
    
    def set_command(self, command):
        self.command = command
    
    def press(self):
        return self.command.execute()
    
    def press_undo(self):
        return self.command.undo()

def main():
    light = Light()
    stereo = Stereo()
    
    button = RemoteButton(LightOnCommand(light))
    print(button.press())
    print(button.press_undo())
    
    button.set_command(StereoOnCommand(stereo))
    print(button.press())
    print(button.press_undo())

if __name__ == "__main__":
    main()
