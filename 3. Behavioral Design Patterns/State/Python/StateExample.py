# State Pattern Example in Python
# TrafficLight cycles through Red, Yellow, Green states

from abc import ABC, abstractmethod

class TrafficLightState(ABC):
    @abstractmethod
    def next_state(self, context):
        pass
    
    @abstractmethod
    def get_color(self):
        pass

class TrafficLight:
    def __init__(self):
        self.state = RedState()
    
    def set_state(self, state):
        self.state = state
    
    def next_state(self):
        self.state.next_state(self)
    
    def get_color(self):
        return self.state.get_color()

class RedState(TrafficLightState):
    def next_state(self, context):
        context.set_state(GreenState())
    
    def get_color(self):
        return "Red"

class YellowState(TrafficLightState):
    def next_state(self, context):
        context.set_state(RedState())
    
    def get_color(self):
        return "Yellow"

class GreenState(TrafficLightState):
    def next_state(self, context):
        context.set_state(YellowState())
    
    def get_color(self):
        return "Green"

def main():
    light = TrafficLight()
    for i in range(6):
        print(f"Light: {light.get_color()}")
        light.next_state()

if __name__ == "__main__":
    main()
