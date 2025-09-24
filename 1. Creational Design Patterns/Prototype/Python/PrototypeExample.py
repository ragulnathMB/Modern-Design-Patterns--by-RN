# Prototype Pattern Example in Python
# Shape cloning system with different shape types

import copy
from abc import ABC, abstractmethod

class Shape(ABC):
    def __init__(self, x=0, y=0, color="white"):
        self.x = x
        self.y = y
        self.color = color
    
    @abstractmethod
    def clone(self):
        pass
    
    @abstractmethod
    def draw(self):
        pass

class Rectangle(Shape):
    def __init__(self, x=0, y=0, color="white", width=10, height=5):
        super().__init__(x, y, color)
        self.width = width
        self.height = height
    
    def clone(self):
        return copy.deepcopy(self)
    
    def draw(self):
        return f"Rectangle at ({self.x},{self.y}), color: {self.color}, size: {self.width}x{self.height}"

class Circle(Shape):
    def __init__(self, x=0, y=0, color="white", radius=5):
        super().__init__(x, y, color)
        self.radius = radius
    
    def clone(self):
        return copy.deepcopy(self)
    
    def draw(self):
        return f"Circle at ({self.x},{self.y}), color: {self.color}, radius: {self.radius}"

class ShapeRegistry:
    def __init__(self):
        self._prototypes = {}
    
    def register_prototype(self, name, prototype):
        self._prototypes[name] = prototype
    
    def create_shape(self, name):
        if name in self._prototypes:
            return self._prototypes[name].clone()
        return None

def main():
    # Create prototypes
    registry = ShapeRegistry()
    registry.register_prototype("blue_rectangle", Rectangle(0, 0, "blue", 20, 10))
    registry.register_prototype("red_circle", Circle(0, 0, "red", 15))
    
    # Clone and modify
    rect1 = registry.create_shape("blue_rectangle")
    rect1.x, rect1.y = 10, 20
    print(rect1.draw())
    
    rect2 = registry.create_shape("blue_rectangle")
    rect2.x, rect2.y = 30, 40
    rect2.width = 25
    print(rect2.draw())
    
    circle1 = registry.create_shape("red_circle")
    circle1.x, circle1.y = 50, 60
    print(circle1.draw())
    
    circle2 = registry.create_shape("red_circle")
    circle2.color = "green"
    circle2.radius = 20
    print(circle2.draw())

if __name__ == "__main__":
    main()
