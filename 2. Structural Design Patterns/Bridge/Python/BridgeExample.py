# Bridge Pattern Example in Python
# Remote control for different devices

from abc import ABC, abstractmethod

class Device(ABC):
    @abstractmethod
    def turn_on(self):
        pass
    
    @abstractmethod
    def turn_off(self):
        pass
    
    @abstractmethod
    def set_volume(self, volume):
        pass

class TV(Device):
    def __init__(self):
        self.volume = 50
        self.on = False
    
    def turn_on(self):
        self.on = True
        return "TV is ON"
    
    def turn_off(self):
        self.on = False
        return "TV is OFF"
    
    def set_volume(self, volume):
        self.volume = volume
        return f"TV volume set to {volume}"

class Radio(Device):
    def __init__(self):
        self.volume = 30
        self.on = False
    
    def turn_on(self):
        self.on = True
        return "Radio is ON"
    
    def turn_off(self):
        self.on = False
        return "Radio is OFF"
    
    def set_volume(self, volume):
        self.volume = volume
        return f"Radio volume set to {volume}"

class RemoteControl:
    def __init__(self, device):
        self.device = device
    
    def power(self):
        return self.device.turn_on()
    
    def volume_up(self):
        return self.device.set_volume(self.device.volume + 10)
    
    def volume_down(self):
        return self.device.set_volume(self.device.volume - 10)

class AdvancedRemote(RemoteControl):
    def mute(self):
        return self.device.set_volume(0)

def main():
    tv = TV()
    tv_remote = RemoteControl(tv)
    print(tv_remote.power())
    print(tv_remote.volume_up())
    
    radio = Radio()
    radio_remote = AdvancedRemote(radio)
    print(radio_remote.power())
    print(radio_remote.mute())

if __name__ == "__main__":
    main()
