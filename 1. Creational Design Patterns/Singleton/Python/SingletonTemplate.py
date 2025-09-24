# Singleton Pattern – Python Template

class Singleton:
    _instance = None
    _initialized = False
    
    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(Singleton, cls).__new__(cls)
        return cls._instance
    
    def __init__(self):
        if not Singleton._initialized:
            # Initialize only once
            Singleton._initialized = True
    
    def operation(self):
        # Singleton operations
        pass

def main():
    s1 = Singleton()
    s2 = Singleton()
    print(f"s1 is s2: {s1 is s2}")
    s1.operation()

if __name__ == "__main__":
    main()
