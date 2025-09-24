# Observer Pattern Example in Python
# WeatherStation notifies Display observers when temperature changes

from abc import ABC, abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self, temperature):
        pass

class Subject(ABC):
    @abstractmethod
    def attach(self, observer):
        pass
    
    @abstractmethod
    def detach(self, observer):
        pass
    
    @abstractmethod
    def notify(self):
        pass

class WeatherStation(Subject):
    def __init__(self):
        self.observers = []
        self.temperature = 0
    
    def attach(self, observer):
        self.observers.append(observer)
    
    def detach(self, observer):
        self.observers.remove(observer)
    
    def notify(self):
        for observer in self.observers:
            observer.update(self.temperature)
    
    def set_temperature(self, temperature):
        self.temperature = temperature
        self.notify()

class PhoneDisplay(Observer):
    def update(self, temperature):
        print(f"Phone: Temperature is {temperature}°C")

class WindowDisplay(Observer):
    def update(self, temperature):
        print(f"Window: Temperature is {temperature}°C")

def main():
    station = WeatherStation()
    phone = PhoneDisplay()
    window = WindowDisplay()
    
    station.attach(phone)
    station.attach(window)
    
    station.set_temperature(25.5)
    station.set_temperature(30.2)

if __name__ == "__main__":
    main()
