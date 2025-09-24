# Composite Pattern Example in Python
# File system: File (leaf) and Directory (composite)

from abc import ABC, abstractmethod

class FileSystemItem(ABC):
    @abstractmethod
    def display(self, depth=0):
        pass
    
    @abstractmethod
    def get_size(self):
        pass

class File(FileSystemItem):
    def __init__(self, name, size):
        self.name = name
        self.size = size
    
    def display(self, depth=0):
        indent = "  " * depth
        print(f"{indent}File: {self.name} ({self.size}KB)")
    
    def get_size(self):
        return self.size

class Directory(FileSystemItem):
    def __init__(self, name):
        self.name = name
        self.items = []
    
    def add(self, item):
        self.items.append(item)
    
    def remove(self, item):
        self.items.remove(item)
    
    def display(self, depth=0):
        indent = "  " * depth
        print(f"{indent}Directory: {self.name}/")
        for item in self.items:
            item.display(depth + 1)
    
    def get_size(self):
        total = 0
        for item in self.items:
            total += item.get_size()
        return total

def main():
    root = Directory("root")
    docs = Directory("docs")
    docs.add(File("readme.txt", 5))
    docs.add(File("manual.pdf", 150))
    root.add(docs)
    root.add(File("config.ini", 2))
    
    root.display()
    print(f"Total size: {root.get_size()}KB")

if __name__ == "__main__":
    main()
