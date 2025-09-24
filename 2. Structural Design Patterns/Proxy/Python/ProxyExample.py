# Proxy Pattern Example in Python
# Image viewer with lazy-loading proxy

from abc import ABC, abstractmethod

class Image(ABC):
    @abstractmethod
    def display(self):
        pass

class RealImage(Image):
    def __init__(self, filename):
        self.filename = filename
        self._load_from_disk()
    
    def _load_from_disk(self):
        print(f"Loading image: {self.filename}")
    
    def display(self):
        return f"Displaying: {self.filename}"

class ProxyImage(Image):
    def __init__(self, filename):
        self.filename = filename
        self.real_image = None
    
    def display(self):
        if self.real_image is None:
            self.real_image = RealImage(self.filename)
        return self.real_image.display()

def main():
    image = ProxyImage("photo.jpg")
    print(image.display())  # loads then displays
    print(image.display())  # displays without loading

if __name__ == "__main__":
    main()
